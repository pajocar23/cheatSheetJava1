/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.repository.db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Mr OLOGIZ
 */
public class DbConnectionFactory {
    private static DbConnectionFactory instance;
    private Connection connection;

    private DbConnectionFactory() {
    }
    
    public static DbConnectionFactory getInstance(){
        if(instance==null){
            instance=new DbConnectionFactory();
        }
        return instance;
    }
    
    public Connection getConnection() throws Exception{
        if(connection==null || connection.isClosed()){
            String url="jdbc:mysql://localhost:3306/imebaze";
            String user="root";
            String password="";
            connection=DriverManager.getConnection(url, user, password);
        }
        return connection;
    }
}
