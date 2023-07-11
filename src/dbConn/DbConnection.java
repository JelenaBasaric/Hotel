/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbConn;
 import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author jbasa
 */
public class DbConnection {
    private  final Connection connection;
    private static DbConnection instance;

    private DbConnection() throws Exception {
        String url="jdbc:mysql://localhost:3306/hotel";
        String user="root";
        String password="";
       connection=DriverManager.getConnection(url, user, password);
    }

    public java.sql.Connection getConnection() {
        return connection;
    }

    public static DbConnection getInstance() throws Exception{
        if(instance==null)
        {
            instance=new DbConnection();
        }
        return instance;
    }
    
    
    
    
    
}