/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udoojobs.sql.util;

import com.udoojobs.model.Job;
import com.udoojobs.model.Review;
import java.util.ArrayList;

/**
 *
 * @author zepengzhao
 */
public class JobSqlBuilder {
    
        
    /*
    *@author Felix & Zepeng Zhao
    */
    public static String createJobSql(Job job){
        String sql = "insert into job(user_id,title,info,  "
                + " street, city, state, country, zip_code,  "
                + "pay_amount) values(";
        sql += job.getUserId()==null?"NULL,":job.getUserId()+",";
        sql += job.getTitle()==null?"NULL,":"\""+job.getTitle()+"\",";
        sql += job.getDesc()==null?"NULL,":"\""+job.getDesc()+"\",";
        //sql += job.getStatus(); 
        //sql += job.getStartTime()==null?"NULL,":"\""+job.getStartTime()+"\",";
        //sql += job.getExpTime()==null?"NULL,":"\""+job.getExpTime()+"\",";
        sql += job.getStreet()==null?"NULL,":"\""+job.getStreet()+"\",";
        sql += job.getCity()==null?"NULL,":"\""+job.getCity()+"\",";
        sql += job.getState()==null?"NULL,":"\""+job.getState()+"\",";
        sql += job.getCountry()==null?"NULL,":"\""+job.getCountry()+"\",";
        sql += job.getZipCode()==null?"NULL,":"\""+job.getZipCode()+"\",";
        //sql += job.getPay_type();
        sql += job.getPayment()==null?"NULL,":job.getPayment();
        sql += ")";
        return sql;
    }
    
    public static String addReviewSql(Review review){
        String sql = "insert into review (user_id, user_id1, rating, Comment)"
                + " values(";
        sql += review.getUserId1()==null?"NULL,":review.getUserId1()+",";
        sql += review.getUserId2()==null?"NULL,":review.getUserId2()+",";
        sql += review.getRating()+",";
        sql += review.getComment()==null?"NULL":"\""+review.getComment()+"\"";
        //sql += review.getApplicationId()==null?"NULL":review.getApplicationId();
        sql += ")";
        return sql;
    }

}
