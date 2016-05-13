/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udoojobs.service;

import com.udoojobs.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zepengzhao
 */
public class UpdateService {
 
    private Connection client ;
    private static final Logger LOGGER = Logger.getLogger(SearchUserService.class.getName());
    public UpdateService(){
        client = ClientService.getClient();
    }
    
    public int update_bio(User user){
        String sql = "update user set user.bio=\""+user.getBio()+"\" where ";
        
        if(user.getEmail() != null){
            sql+="user.email_addr=\""+user.getEmail()+"\"";
        }else if((user.getID()) != null){
            sql+="user.id="+user.getID();
        }else{
            return 0;
        }
        
        LOGGER.info("Starting to update bio by sql:"+sql);    
        PreparedStatement preparedStmt = null;
        try{
            preparedStmt = client.prepareStatement(sql);
            preparedStmt.executeUpdate();
            LOGGER.info("user bio updated");
            
        }catch(Exception e){
            LOGGER.log(Level.SEVERE, e.getMessage(),e);
            return 2;
        }finally{
            if(preparedStmt != null){
                try{
                    preparedStmt.close();
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
        
        return 1;
    }
    
    
    
}
