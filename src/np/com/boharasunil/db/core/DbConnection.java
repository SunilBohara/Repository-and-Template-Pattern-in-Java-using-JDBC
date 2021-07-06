/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package np.com.boharasunil.db.core;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author sunilbohara
 */
public class DbConnection {
    public static Connection getConnection() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
    }
}
