package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Nikita Nesterov
 */
class MySQLDriverManager {


    static String URL = "jdbc:mysql://127.0.0.1:3306/andersen_task3";
    static String user = "root";
    static String pass = "testtest";


    public static Connection createConnection () throws SQLException {
        Connection connection = DriverManager.getConnection(URL, user, pass);
        return  connection;
    }
}
