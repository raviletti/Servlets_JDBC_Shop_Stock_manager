package dao;

import model.Fan;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class FanDaoImpl implements AbstractFanDao<Integer, String, Fan> {
    private MysqlConnection mysqlcon;
    public static final String SQL_SELECT_ALL_FANS =
            "SELECT * FROM fans";
    public static final String SQL_SELECT_FAN_ID =
            "SELECT * FROM fans WHERE id=?";
    public static final String SQL_SELECT_FANS_MODELNAME =
            "SELECT * FROM fans WHERE model_name=?";
    public static final String SQL_SELECT_FANS_PRODUCERNAME =
            "SELECT * FROM fans WHERE producer_name=?";
    public static final String SQL_DELETE_FAN_ID =
            "DELETE FROM fans WHERE id=?";
    public static final String SQL_CREATE_FAN =
            "INSERT INTO fans (model_name, producer_name, quantity_in_stock, " +
                    "piece_volume, piece_weight, in_order, location, description) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String SQL_UPDATE_FANS =
            "UPDATE fans SET model_name = ?, producer_name = ?, quantity_in_stock = ?, piece_volume = ?, " +
                    "piece_weight = ?, in_order= ?, location =?, description =? WHERE id= ?";
    public static final  String SQL_GETSTOCK =
            "SELECT quantity_in_stock, free_stock FROM fans WHERE model_name =?";
    public static final String DRIVER = ResourceBundle.getBundle("database").getString("db.driver");

    public FanDaoImpl(String DBProps){
        this.mysqlcon = new MysqlConnection(DBProps);
    }

    @Override
    public List<Fan> findAll() {
        List<Fan> fans = new ArrayList<>();
        try(Connection connection = mysqlcon.getConnection();
            Statement statement = connection.createStatement()){
            ResultSet rs = statement.executeQuery(SQL_SELECT_ALL_FANS);
            while (rs.next()){
                int id = rs.getInt("id");
                String modelName = rs.getString("model_name");
                String producerName = rs.getString("producer_name");
                int quantity = rs.getInt("quantity_in_stock");
                double volume = rs.getDouble("piece_volume");
                double weight = rs.getDouble("piece_weight");
                int inOrder = rs.getInt("in_order");
                int freeStock = rs.getInt("free_stock");
                String location = rs.getString("location");
                String description = rs.getString("description");

                fans.add(new Fan(id, modelName, producerName, quantity, volume, weight, inOrder, freeStock, location, description));
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return fans;
    }

    @Override
    public Fan findById(Integer id) {
        Fan fan = null;
        try(Connection connection = mysqlcon.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_FAN_ID)){
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()){
                String modelName = rs.getString("model_name");
                String producerName = rs.getString("producer_name");
                int quantity = rs.getInt("quantity_in_stock");
                double volume = rs.getDouble("piece_volume");
                double weight = rs.getDouble("piece_weight");
                int inOrder = rs.getInt("in_order");
                int freeStock = rs.getInt("free_stock");
                String location = rs.getString("location");
                String description = rs.getString("description");
                fan =  new Fan(id, modelName, producerName, quantity, volume, weight, inOrder, freeStock, location, description);
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return fan;
    }

    @Override
    public List<Fan> findByModelName(String modelName) {
        List<Fan> fans = new ArrayList<>();
        try(Connection connection = mysqlcon.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_FANS_MODELNAME)){
            preparedStatement.setString(1, modelName);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String producerName = rs.getString("producer_name");
                int quantity = rs.getInt("quantity_in_stock");
                double volume = rs.getDouble("piece_volume");
                double weight = rs.getDouble("piece_weight");
                int inOrder = rs.getInt("in_order");
                int freeStock = rs.getInt("free_stock");
                String location = rs.getString("location");
                String description = rs.getString("description");


                fans.add(new Fan(id, modelName, producerName, quantity, volume, weight, inOrder, freeStock, location, description));
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return fans;
    }

    @Override
    public List<Fan> findByProducer(String producerName) {
        List<Fan> fans = new ArrayList<>();
        try(Connection connection = mysqlcon.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_FANS_PRODUCERNAME)){
            preparedStatement.setString(1, producerName);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String modelName = rs.getString("model_name");
                int quantity = rs.getInt("quantity_in_stock");
                double volume = rs.getDouble("piece_volume");
                double weight = rs.getDouble("piece_weight");
                int inOrder = rs.getInt("in_order");
                int freeStock = rs.getInt("free_stock");
                String location = rs.getString("location");
                String description = rs.getString("description");

                fans.add(new Fan(id, modelName, producerName, quantity, volume, weight, inOrder, freeStock, location, description));
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return fans;
    }

    @Override
    public boolean deleteById(Integer id) {
        boolean isDeleted = false;
        try (Connection connection = mysqlcon.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_FAN_ID)) {
            preparedStatement.setInt(1, id);
            isDeleted = (preparedStatement.executeUpdate() == 1) ?  true :  false;


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return isDeleted;
    }

    @Override
    public boolean delete(Fan entity) {
        boolean isDeleted = false;
        try (Connection connection = mysqlcon.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_FAN_ID)) {
            preparedStatement.setInt(1, entity.getId());
            isDeleted = preparedStatement.executeUpdate() == 1;


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return isDeleted;
    }

    @Override
    public boolean create(Fan entity) {
        boolean isAdded = false;
        try (Connection connection = mysqlcon.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_CREATE_FAN)) {
            preparedStatement.setString(1, entity.getModelName());
            preparedStatement.setString(2, entity.getProducerName());
            preparedStatement.setInt(3, entity.getQuantity());
            preparedStatement.setDouble(4, entity.getVolume());
            preparedStatement.setDouble(5, entity.getWeight());
            preparedStatement.setInt(6, entity.getInOrder());
            preparedStatement.setString(7, entity.getLocation());
            preparedStatement.setString(8, entity.getDescription());
            isAdded = preparedStatement.executeUpdate() == 1;


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return isAdded;
    }

    @Override
    public Fan update(Fan entity) {
        try (Connection connection = mysqlcon.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_FANS)) {
            preparedStatement.setInt(9, entity.getId());
            preparedStatement.setString(1, entity.getModelName());
            preparedStatement.setString(2, entity.getProducerName());
            preparedStatement.setInt(3, entity.getQuantity());
            preparedStatement.setDouble(4, entity.getVolume());
            preparedStatement.setDouble(5, entity.getWeight());
            preparedStatement.setInt(6, entity.getInOrder());
            preparedStatement.setString(7, entity.getLocation());
            preparedStatement.setString(8, entity.getDescription());

            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return entity;
    }


}
