package dao;

import com.mysql.cj.jdbc.Driver;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ResourceBundle;

public class MysqlConnection {


    private ResourceBundle resource;
    private String user;
    private String password;
    private String host;
    private int port;
    private String database;
    private String connectionString;
    private String driver;

    public MysqlConnection(String DBProperties) {
        this.resource =  ResourceBundle.getBundle(DBProperties);
        this.user = resource.getString("db.user");
        this.password = resource.getString("db.password");
        this.host = resource.getString("db.host");
        this.port = Integer.parseInt(resource.getString("db.port"));
        this.database = resource.getString("db.name");
        this.connectionString = resource.getString("db.url");
        this.driver = resource.getString("db.driver");
    }

    public Connection getConnection() throws SQLException{
        return getDatasource().getConnection();
    }

    public  DataSource getDatasource() throws SQLException {
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(connectionString + database);
        ds.setUsername(user);
        ds.setPassword(password);
        ds.setDriver(new Driver());
        //pool default size
        ds.setInitialSize(2);
        return ds;
    }

    public void close(ResultSet rs) throws SQLException {
        rs.close();
    }

    public void close(Statement statement) throws SQLException {
        statement.close();
    }

    public void close(PreparedStatement statement) throws SQLException {
        statement.close();
    }

    public void close(Connection cnn) throws SQLException {
        cnn.close();
    }

    public void setDatabaseUser(String userdb) {
        user = userdb;
    }

    public void setDatabasePassword(String passwd) {
        password = passwd;
    }

    public void reloadStringConnection() {
        connectionString = "jdbc:mysql://" + host + ":" + port + "/" + database;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getConnectionString() {
        return connectionString;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }


}
