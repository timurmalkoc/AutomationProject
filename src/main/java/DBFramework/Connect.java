package DBFramework;

import utils.ConfigsReader;

import java.sql.*;

public class Connect {
    private static Connection connection = null;
    private static String DBConfig = "resources/DB.properties";

    public Statement setUp() throws SQLException {
        ConfigsReader.readProperties(DBConfig);
        connection = DriverManager.getConnection(ConfigsReader.getProperty("url"),ConfigsReader.getProperty("user"),ConfigsReader.getProperty("password"));
        Statement st = connection.createStatement();

        return st;
    }


    public void tearDown() throws SQLException {
        if (connection!=null)
        connection.close();
    }

}
