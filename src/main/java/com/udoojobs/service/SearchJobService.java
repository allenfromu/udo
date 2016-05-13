/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udoojobs.service;

import com.udoojobs.model.Job;
import java.math.BigInteger;
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
public class SearchJobService {
    Connection client ;
    private static final Logger LOGGER = Logger.getLogger(SearchUserService.class.getName());
    public SearchJobService(){
        client = ClientService.getClient();
    }
    
    public ArrayList<Job> getJobs(){
        ArrayList<Job> jobs = new ArrayList<Job>();
        Statement stmt = null;
        try{
            String sql = "select * from job";
            LOGGER.info("Executing sql to retrieve jobs:"+sql);
            stmt= client.createStatement();           
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Job job = new Job();
                job.setId((BigInteger)rs.getObject("id"));
                job.setTitle(rs.getString("title"));
                job.setDesc(rs.getString("info"));
                job.setCity(rs.getString("city"));
                job.setCountry(rs.getString("country"));
                job.setStreet(rs.getString("street"));
                job.setZipCode("zip_code");
                job.setState("state");
                job.setUserId((BigInteger)rs.getObject("user_id"));
                job.setStatus(rs.getInt("status"));
                //job.setPostTime(rs.getTimestamp("post_time"));
                //ArrayList<JobCategory> job_categories = new ArrayList<JobCategory>
                jobs.add(job);
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
        return jobs;
    }
           
}
