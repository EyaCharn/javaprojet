/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectionBD;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asus
 */
public class DataSource {

    private Connection connection;
    private final String url = "jdbc:mysql://localhost:3306/caritass";
    private final String user = "root";
    private final String pwd = "";
    public static DataSource instance;

    public Connection getConnection() {
        return connection;
    }

    private DataSource() {

        try {
            connection =  DriverManager.getConnection(url, user, pwd);
        } catch (SQLException ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static DataSource getInstance() {
        if (instance == null) {
            instance = new DataSource();
        }
        return instance;
    }

}
