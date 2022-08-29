//package dao;
//
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.ResourceBundle;
//
//public class DAOTEST implements AbstractDao<Integer, Developer> {
//
//    public static final String SQL_SELECT_DEVELOPER_ROW =
//            "SELECT * FROM developers WHERE ?=Ravil";
//    public static final String DRIVER = ResourceBundle.getBundle("database").getString("db.driver");
//
//
//
//
//
//
//    public List<Developer> findBydirstName(String firstName) {
//        List<Developer> developers = new ArrayList<>();
//        try (Connection connection = ConnectorDB.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM developers WHERE first_name = ?")) {
//            Class.forName(DRIVER);
//            int maxPrice = 50000;
//            preparedStatement.setString(1, firstName);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//
//                int id = resultSet.getInt("id");
//                String lastName = resultSet.getString("last_name");
//                String department = resultSet.getString("department");
//                int salary = resultSet.getInt("salary");
//                developers.add( new Developer(id, firstName, lastName, department, 3, salary));
//                System.out.println(id + " " + firstName + " " + department);
//                System.out.println(lastName + " " + salary);
//                System.out.println("#######################################");
//            }
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//return developers;
//    }
//
//
//        @Override
//    public List<Developer> findAll() {
//        return null;
//    }
//
//    @Override
//    public Developer findById(Integer id) {
//        return null;
//    }
//
//    @Override
//    public boolean deleteById(Integer id) {
//        return false;
//    }
//
//    @Override
//    public boolean delete(Developer entity) {
//        return false;
//    }
//
//    @Override
//    public boolean create(Developer entity) {
//        return false;
//    }
//
//    @Override
//    public Developer update(Developer entity) {
//        return null;
//    }
//}