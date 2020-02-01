/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloodbankk;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ayush
 */
public class DBConnector {
    public static Connection getConnecction() throws Exception{
        Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","ayush123");
        
        return connection;
    }
}
