/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udoojobs.service;

import com.udoojobs.sql.util.UserSqlBuilder;
import com.udoojobs.model.User;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zepengzhao
 */
public class PostUserService {
    
    private static final Logger LOGGER = Logger.getLogger(PostUserService.class.getName());
    private Connection client ;

    public PostUserService(){
        client = ClientService.getClient();
    };
    
    public long createUser(User user){
        
        String sql="";
        Statement stmt=null;
        try{           
            sql = UserSqlBuilder.createUserSql(user);
            LOGGER.info("Create sql to create user:"+sql);
            stmt = client.createStatement();
            stmt.executeUpdate(sql);
            LOGGER.info("New user created");
            stmt.close();
            stmt = null;
            client.close();
            client = null;
            return 1;                        
        }catch(Exception e){
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        }finally{
            if(stmt != null){
                try{
                    stmt.close();
                }catch(Exception e){
                    LOGGER.log(Level.SEVERE, e.getMessage(),e);
                }
            }
            if(client != null){
                try{
                    client.close();
                }catch(Exception e){
                    LOGGER.log(Level.SEVERE, e.getMessage(),e);
                }
            }
        }
        return 0;
    }
    
    /*
    *user id = 0, wrong password
    *user id = 1, user doesn't exist
    *user id = 2, server exception
    */
    public User verify_user(String email, String password){
        String sql = "select id, password from user where email_addr=\""+email+"\"";
        LOGGER.info("Calling verify_user to execute sql:"+sql);
        User user = new User();
        PreparedStatement preStm=null;
        try{
            preStm = client.prepareStatement(sql);
            ResultSet rs = preStm.executeQuery();
            if(rs.next()){
                if(password == null){
                    LOGGER.info("Null password");
                    user.setID(BigInteger.valueOf(3));                    
                }
                else if(password.equals(rs.getString("password"))){
                    LOGGER.info("User exist, pass verification");
                    user.setID((java.math.BigInteger)rs.getObject("id"));
                }else{
                    LOGGER.info("Wrong password.");
                    user.setID(BigInteger.ZERO);
                }
            }else{
                LOGGER.info("User doesn't exist.");
                user.setID(BigInteger.ONE);
            }
        }catch(Exception e){
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
            user.setID(BigInteger.valueOf(2));
        }finally{
            if(preStm != null){
                try{
                    preStm.close();
                }catch(Exception e){
                    LOGGER.log(Level.SEVERE, e.getMessage(),e);
                }
            }
            if(client != null){
                try{
                    client.close();
                }catch(Exception e){
                    LOGGER.log(Level.SEVERE, e.getMessage(),e);
               
                }
            }
        }
        return user;
    }
    
}
