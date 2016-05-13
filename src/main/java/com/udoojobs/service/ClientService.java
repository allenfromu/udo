/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udoojobs.service;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
/**
 *
 * @author zepengzhao
 */
public class ClientService {
    //private static Connection client = null;
    private static DataSource ds = null;
    private static final Logger LOGGER = Logger.getLogger(ClientService.class.getName());
    
    private static void intit(){
        
        try{
            LOGGER.info("Establishing DataResource for connection pool.");
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            ds = (DataSource) envContext.lookup("jdbc/db1");
            /*
            if(client != null && !client.isClosed()){
                client.close();
            }           
            String user = "all";
            String password = "2016";
            String url = "jdbc:mysql://udoojobs.com/db1?autoReconnect=true";
            Class.forName("com.mysql.jdbc.Driver").newInstance();      //register driver
            client = DriverManager.getConnection(url, user, password); //get client connection
            LOGGER.info("Client Connected to Database System Created");
                    */
        }catch(Exception e){
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        }       
        
    }
    
    
    public static Connection getClient(){
        LOGGER.info("Retrieving Client Connection to the Database System");
        try{
            /*
            if(client == null || client.isClosed()){
                ClientService.intit();
            }*/
            if(ds == null){
                ClientService.intit();
            }
            return ds.getConnection();
        }catch(SQLException e){
            LOGGER.log(Level.SEVERE, "ClientService:"+e.getMessage(), e);
            ClientService.intit();
        }  
        //return client;       
        return null;
    }
    
    
}
