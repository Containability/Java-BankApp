/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nypprojectbank;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;

/**
 *
 * @author msi
 */
public class DatabaseCon {

     
      private static final String dbURL = "jdbc:derby://localhost:1527/nypdb;user=APP;password=APP";
    private static String tableName = "nyp_bank";
    private static Connection conn = null;
    private static Statement stmt = null;
     
     
     
     
     
     
     
     
     
      public static Connection createConnection()
    {
        try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            //Get a connection
            conn = DriverManager.getConnection(dbURL); 
        }
        catch (Exception except)
        {
            except.printStackTrace();
        }
   
    return conn;
    }
}
