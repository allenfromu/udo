/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udoojobs.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zepengzhao
 */
public class DeleteService {
    Connection client ;
    private static final Logger LOGGER = Logger.getLogger(SearchUserService.class.getName());
    public DeleteService(){
        client = ClientService.getClient();
    }
    
    public int delete_job(String jid){
        String sql = "delete from job where job.id = "+jid;
        PreparedStatement preparedStmt = null;
        try{
            LOGGER.info("executing delete sql:"+sql);
            preparedStmt = client.prepareStatement(sql);
            preparedStmt.execute();
            LOGGER.info("Delete done!");
            preparedStmt.close();
            preparedStmt = null;
            client.close();
            client = null;
            return 1;
        }catch(Exception e){
            LOGGER.log(Level.SEVERE,e.getMessage(),e);
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
        return 0;
    }
    
}
