/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udoojobs.service;

import com.udoojobs.model.Job;
import com.udoojobs.model.Review;
import com.udoojobs.sql.util.JobSqlBuilder;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zepengzhao
 */
public class PostJobService {
    private static final Logger LOGGER = Logger.getLogger(PostUserService.class.getName());
    private Connection client ;

    public PostJobService(){
        client = ClientService.getClient();
    };
    
    public Job createJob(Job job){
        String sql = JobSqlBuilder.createJobSql(job);      
        LOGGER.info("Creating job with sql:"+sql);
        Statement stmt = null;
       try{           
            //LOGGER.info("Create sql to create user:"+sql);
            stmt = client.createStatement();
            stmt.executeUpdate(sql);
            LOGGER.info("New job created");
            ArrayList<Integer> jc = job.getJobCategories();
            sql = "select last_insert_id() as jid";
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                String jid = ((java.math.BigInteger)rs.getObject("jid")).toString();
                job.setId((java.math.BigInteger)rs.getObject("jid"));
                LOGGER.info("job id:"+jid);
                if( jc != null){
                    for(Integer i: jc){
                        LOGGER.info("Add job category:"+i);
                        sql = "insert into job_has_category(job_id, job_category_id)"
                        + " values("+jid+","+i+")";
                        stmt.execute(sql);
                    }
                }  
                stmt.close();
                stmt = null;
                client.close();
                client = null;
                return job;
            }
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
        return null;
    }
    
    public Review addReview(Review r){
        String sql = JobSqlBuilder.addReviewSql(r);
        LOGGER.info("Creating review with sql:"+sql);
        Statement stmt = null;
       try{           
            //LOGGER.info("Create sql to create user:"+sql);
            stmt = client.createStatement();
            stmt.executeUpdate(sql);
            LOGGER.info("New Review created");
            sql = "select last_insert_id() as id";
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                java.math.BigInteger id = ((java.math.BigInteger)rs.getObject("id"));
                r.setId(id);
                stmt.close();
                stmt = null;
                client.close();
                client = null;
                return r;
            }
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
        return r;
    }
    
}
