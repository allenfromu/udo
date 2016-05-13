/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udoojobs.service;

import com.udoojobs.model.Review;
import com.udoojobs.model.User;
import com.udoojobs.model.UserImage;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zepengzhao
 */
public class SearchUserService {

    private Connection client ;
    private static final Logger LOGGER = Logger.getLogger(SearchUserService.class.getName());
    public SearchUserService(){
        
        client = ClientService.getClient();
    }
    
    public int check_user(String sql){
        LOGGER.info("Calling check_user function to execute sql:"+sql);
        PreparedStatement preStm = null;
        try{
            preStm = client.prepareStatement(sql);
            ResultSet rs = preStm.executeQuery();
            if(rs.next()){
                LOGGER.info("User exist");
                preStm.close();
                preStm = null;
                client.close();
                client = null;
                return 1;
            }else{
                LOGGER.info("User doesn't exist");
                preStm.close();
                preStm = null;
                client.close();
                client = null;                
                return 0;
            }
        }catch(Exception e){
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
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
        return 0;
    }
    
    public java.math.BigInteger verify_user(String sql, String password){
        LOGGER.info("Calling verify_user to execute sql:"+sql);
        PreparedStatement preStm = null;
        try{
            preStm = client.prepareStatement(sql);
            ResultSet rs = preStm.executeQuery();
            if(rs.next()){
                if(password.equals(rs.getString("password"))){
                    LOGGER.info("User exist, passed verification");
                    return (java.math.BigInteger)rs.getObject("id");
                }
                LOGGER.info("Wrong password");
                preStm.close();
                preStm = null;
                client.close();
                client = null;                
                return null;
            }else{
                LOGGER.info("User doesn't exist.");
                preStm.close();
                preStm = null;
                client.close();
                client = null;                
                return null;
            }
        }catch(Exception e){
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
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
        return null;
    }
    
    public ArrayList<Review> getUserReviews(String id){
        ArrayList<Review> reviews = new ArrayList<Review>();
        String sql = "select * from review where user_id="+id;
        PreparedStatement preStm = null;
        try{
            LOGGER.info("Executing sql to get user_images:"+sql);
            preStm = client.prepareStatement(sql);
            ResultSet rs = preStm.executeQuery();
            while(rs.next()){
                Review r = new Review();
                r.setId((BigInteger)rs.getObject("id"));
                r.setUserId1((BigInteger)rs.getObject("user_id"));
                r.setUserId2((BigInteger)rs.getObject("user_id1"));
                r.setRating(rs.getInt("rating"));
                r.setComment(rs.getString("Comment"));
                r.setApplicationId((BigInteger)rs.getObject("application_id"));
                reviews.add(r);
            }
        }catch(Exception e){
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
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
        return reviews;
    }
    
    public ArrayList<UserImage> getUserImages(String id){
        String sql = "select * from user_image where user_id = "+id;
        ArrayList<UserImage> user_images = new ArrayList<UserImage>();
        PreparedStatement preStm = null;
        try{
            LOGGER.info("Executing sql to get user_images:"+sql);
            preStm = client.prepareStatement(sql);
            ResultSet rs = preStm.executeQuery();
            while(rs.next()){
                UserImage ui = new UserImage();
                ui.setCreatedTime(rs.getTimestamp("created_time"));
                ui.setId((java.math.BigInteger)rs.getObject("id"));
                ui.setType(rs.getInt("type"));
                ui.setUrl(rs.getString("url"));
                user_images.add(ui);
            }
        }catch(Exception e){
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
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
        return user_images;
    }
    
    
    public User searchUserByID(String id){
        String sql = "select * from user where id = "+ id;

        User user = new User();
        LOGGER.info("searching user with sql:"+sql);
        PreparedStatement preStm = null;
        try{
            preStm = client.prepareStatement(sql);
            ResultSet rs = preStm.executeQuery();
            if(rs.next()){
                String tmp;
                if((tmp=(String)rs.getObject("street"))!=null){
                    user.setStreet(tmp);
                }
                if((tmp=(String)rs.getObject("city"))!=null){
                    user.setCity(tmp);

                }
                if((tmp=(String)rs.getObject("state"))!=null){
                    user.setState(tmp);
                }
                if((tmp=(String)rs.getObject("country"))!=null){
                    user.setCountry(tmp);
                }           

                user.setDisplay_Name((String)rs.getObject("display_name"));
                user.setBio(rs.getString("bio"));
                user.setEmail((String)rs.getObject("email_addr"));
                user.setID((java.math.BigInteger)rs.getObject("id"));  
                user.setPassword(rs.getString("password"));
                user.setPhone(rs.getString("phone_numb"));
                user.setProfileURL(rs.getString("profile_url"));
                
            }else{
                LOGGER.info("user doesn't exist.");
            }
            sql = "select avg(rating) as av from review where user_id = "+id;
            LOGGER.info("Executing sql to get average rating:"+sql);
            rs = preStm.executeQuery(sql);
            if(rs.next()){
                user.setAveRating(rs.getFloat("av"));
            }
            
        }catch(Exception e){
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
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
    
    
    
    public ArrayList<User> getUsers(){
        ArrayList<User> users = new ArrayList<User>();
        Statement stmt = null;
        try{
            String sql = "select * from user";    
            stmt = client.createStatement();
            ResultSet rs = stmt.executeQuery(sql);           
            while(rs.next()){
                User user = new User();
                String tmp;
                if((tmp=(String)rs.getObject("street"))!=null){
                    user.setStreet(tmp);
                }
                if((tmp=(String)rs.getObject("city"))!=null){
                    user.setCity(tmp);

                }
                if((tmp=(String)rs.getObject("state"))!=null){
                    user.setState(tmp);
                }
                if((tmp=(String)rs.getObject("country"))!=null){
                    user.setCountry(tmp);
                }           

                user.setDisplay_Name((String)rs.getObject("display_name"));
                user.setBio(rs.getString("bio"));
                user.setEmail((String)rs.getObject("email_addr"));
                user.setID((java.math.BigInteger)rs.getObject("id")); 
                users.add(user);
            }
                
        }catch(Exception e){
            LOGGER.log(Level.SEVERE, "getUsers:"+e.getMessage(), e);
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
        return users;       
    }
    
    
    
    
}
