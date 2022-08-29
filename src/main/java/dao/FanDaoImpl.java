package dao;

import model.Fan;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class FanDaoImpl implements AbstractFanDao<Integer, String, Fan> {
    public static final String SQL_SELECT_ALL_FANS =
            "SELECT * FROM fans";
    public static final String SQL_SELECT_FAN_ID =
            "SELECT * FROM fans WHERE id=?";
    public static final String SQL_SELECT_FAN_MODELNAME =
            "SELECT * FROM fans WHERE model_name=?";
    public static final String SQL_SELECT_FANS_PRODUCER =
            "SELECT * FROM fans WHERE producer=?";
    public static final String SQL_DELETE_FAN_ID =
            "DELETE FROM fans WHERE id=?";
    public static final String SQL_SELECT_FANS_MODELNAME =
            "SELECT * FROM fans WHERE model_name=?";
    public static final String SQL_CREATE_FAN =
            "INSERT INTO fans (model_name, producer_name, quantity_in_stock, " +
                    "piece_volume, piece_weight, in_order, free_stock) VALUES (?, ?, ?, ?, ?, ?, ?)";
    public static final String SQL_UPDATE_FANS =
            "UPDATE fans SET model_name = ?, producer_name = ?, quantity_in_stock = ?, piece_volume = ?, " +
                    "piece_weight =?, in_order=?, free_stock=? WHERE id=?";
    public static final  String SQL_GETSTOCK =
            "SELECT quantity_in_stock, free_stock FROM fans WHERE model_name =?";
    public static final String DRIVER = ResourceBundle.getBundle("database").getString("db.driver");


    @Override
    public List<Fan> findAll() {
        List<Fan> fans = new ArrayList<>();
        try(Connection connection = ConnectorDB.getConnection();
            Statement statement = connection.createStatement()){
            Class.forName(DRIVER);
            ResultSet rs = statement.executeQuery(SQL_SELECT_ALL_FANS);
            while (rs.next()){
                int id = rs.getInt(1);
                String modelName = rs.getString(2);
                String producerName = rs.getString(3);
                int quantity = rs.getInt(4);
                double volume = rs.getDouble(5);
                double weight = rs.getInt(6);
                int inOrder = rs.getInt(7);
                int freeStock = rs.getInt(8);

                fans.add(new Fan(id, modelName, producerName, quantity, volume, weight, inOrder, freeStock));
            }
        }
        catch (SQLException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        return fans;
    }

    @Override
    public Fan findById(Integer id) {
        Fan fan = null;
        try(Connection connection = ConnectorDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_FAN_ID)){
            Class.forName(DRIVER);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()){
                String modelName = rs.getString(2);
                String producerName = rs.getString(3);
                int quantity = rs.getInt(4);
                double volume = rs.getDouble(5);
                double weight = rs.getInt(6);
                int inOrder = rs.getInt(7);
                int freeStock = rs.getInt(8);
                fan =  new Fan(id, modelName, producerName, quantity, volume, weight, inOrder, freeStock);
            }
        }
        catch (SQLException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        return fan;
    }

    @Override
    public List<Fan> findByModelName(String modelName) {
        List<Fan> fans = new ArrayList<>();
        try(Connection connection = ConnectorDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_FANS_MODELNAME)){
            Class.forName(DRIVER);
            preparedStatement.setString(1, modelName);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt(1);
                String producerName = rs.getString(3);
                int quantity = rs.getInt(4);
                double volume = rs.getDouble(5);
                double weight = rs.getInt(6);
                int inOrder = rs.getInt(7);
                int freeStock = rs.getInt(8);

                fans.add(new Fan(id, modelName, producerName, quantity, volume, weight, inOrder, freeStock));
            }
        }
        catch (SQLException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        return fans;
    }

    @Override
    public List<Fan> findByProducer(String producer) {
        List<Fan> fans = new ArrayList<>();
        try(Connection connection = ConnectorDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_FANS_PRODUCER)){
            Class.forName(DRIVER);
            preparedStatement.setString(1, producer);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt(1);
                String modelName = rs.getString(2);
                int quantity = rs.getInt(4);
                double volume = rs.getDouble(5);
                double weight = rs.getInt(6);
                int inOrder = rs.getInt(7);
                int freeStock = rs.getInt(8);

                fans.add(new Fan(id, modelName, producer, quantity, volume, weight, inOrder, freeStock));
            }
        }
        catch (SQLException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        return fans;
    }

    @Override
    public boolean deleteById(Integer id) {
        boolean isDeleted = false;
        try (Connection connection = ConnectorDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_FAN_ID)) {
            Class.forName(DRIVER);
            preparedStatement.setInt(1, id);
            isDeleted = (preparedStatement.executeUpdate() == 1) ?  true :  false;


        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return isDeleted;
    }

    @Override
    public boolean delete(Fan entity) {
        boolean isDeleted = false;
        try (Connection connection = ConnectorDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_FAN_ID)) {
            Class.forName(DRIVER);
            preparedStatement.setInt(1, entity.getId());
            isDeleted = preparedStatement.executeUpdate() == 1;


        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return isDeleted;
    }

    @Override
    public boolean create(Fan entity) {
        boolean isAdded = false;
        try (Connection connection = ConnectorDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_CREATE_FAN)) {
            Class.forName(DRIVER);
            preparedStatement.setString(1, entity.getModelName());
            preparedStatement.setString(2, entity.getProducerName());
            preparedStatement.setInt(3, entity.getQuantity());
            preparedStatement.setDouble(4, entity.getVolume());
            preparedStatement.setDouble(5, entity.getWeight());
            preparedStatement.setInt(6, 0);
            preparedStatement.setInt(7, entity.getFreeStock());
            isAdded = preparedStatement.executeUpdate() == 1;


        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return isAdded;
    }

    @Override
    public Fan update(Fan entity) {
        try (Connection connection = ConnectorDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_FANS)) {
            Class.forName(DRIVER);
            preparedStatement.setInt(6, entity.getId());
            preparedStatement.setString(1, entity.getModelName());
            preparedStatement.setString(2, entity.getProducerName());
            preparedStatement.setInt(3, entity.getQuantity());
            preparedStatement.setDouble(4, entity.getVolume());
            preparedStatement.setDouble(5, entity.getWeight());
            preparedStatement.setInt(6, entity.getInOrder());
            preparedStatement.setInt(7, entity.getFreeStock());

            preparedStatement.executeUpdate();


        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return entity;
    }

    @Override
    public String getStock(Fan entity) {
        String stock = "quantity in stock: ";
        String free = "free stock: ";
        try(Connection connection = ConnectorDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_FAN_ID)){
            Class.forName(DRIVER);
            preparedStatement.setString(1, entity.getModelName());
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()){

                int quantity = rs.getInt(4);
                int freeStock = rs.getInt(8);
                stock += quantity;
                free += freeStock;
            }
        }
        catch (SQLException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        return stock + " " + free;
    }

}
