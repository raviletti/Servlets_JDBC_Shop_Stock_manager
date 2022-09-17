package ServiceTests;


import dao.MysqlConnection;
import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;

public class TestDBService {
    private String props;
    public TestDBService(String props) {
        this.props = props;
    }

    protected void createTestTable(){
            MysqlConnection mysqlcon =  new MysqlConnection(props);
            mysqlcon.setDatabase("");
            try(Connection con = mysqlcon.getConnection()){
            System.out.println("Creating database......");
            ScriptRunner sr = new ScriptRunner(con);
            Reader reader = new BufferedReader(new FileReader("src/test/resources/create.sql"));
            sr.runScript(reader);
        }
        catch (FileNotFoundException | SQLException e){
            System.out.println(e.getMessage());
        }
    }

    protected void insertTestTable(){
       // Connection con = null;
        MysqlConnection mysqlcon = new MysqlConnection(props);
        mysqlcon.setDatabase("");
        try (Connection con = mysqlcon.getConnection()){
            System.out.println("Insering data......");
            ScriptRunner sr = new ScriptRunner(con);
            Reader reader = new BufferedReader(new FileReader("src/test/resources/insert.sql"));
            sr.runScript(reader);
        }
        catch (FileNotFoundException | SQLException e){
            System.out.println(e.getMessage());
        }
    }

    protected void truncateTestTable(){
            MysqlConnection mysqlcon = new MysqlConnection(props);
            mysqlcon.setDatabase("");
        try(Connection con = mysqlcon.getConnection()){
            System.out.println("Deleting data......");
            ScriptRunner sr = new ScriptRunner(con);
            Reader reader = new BufferedReader(new FileReader("src/test/resources/truncate.sql"));
            sr.runScript(reader);
        }
        catch (FileNotFoundException | SQLException e){
            System.out.println(e.getMessage());
        }
    }

    protected void deleteTestTable() {
            MysqlConnection mysqlcon = new MysqlConnection(props);
            mysqlcon.setDatabase("");
            try(Connection con = mysqlcon.getConnection()){
            System.out.println("Deleting database......");
            ScriptRunner sr = new ScriptRunner(con);
            Reader reader = new BufferedReader(new FileReader("src/test/resources/drop.sql"));
            sr.runScript(reader);
        }
        catch (FileNotFoundException | SQLException e){
            System.out.println(e.getMessage());
        }
    }


}
