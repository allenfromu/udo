/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udoojobs.rest;

import com.udoojobs.model.Review;
import com.udoojobs.sql.util.UserSqlBuilder;
import com.udoojobs.model.User;
import com.udoojobs.model.UserImage;
import com.udoojobs.service.SearchUserService;
import java.util.ArrayList;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author zepengzhao
 */
@Path("searchuser")
public class SearchUserResource {
    
    private final SearchUserService searchClient = new SearchUserService();
    
   //specific user id 
    @Context
    private UriInfo context;

    
    @GET
    @Path("users")
    @Produces("application/json")
    public ArrayList<User> getUsers(){
        System.out.println("users path called");
        return searchClient.getUsers();
    }
    
    //specific user id 
    @GET
    @Path("user/{id}")
    @Produces("application/json")
    public User getUserById(@PathParam("id") java.math.BigInteger user_id){
        return searchClient.searchUserByID(user_id.toString());
    }
    //specific user id 
    @GET
    @Path("user_reviews/{id}")
    @Produces("application/json")
    public ArrayList<Review> getUserReviewById(@PathParam("id") String user_id){
        return searchClient.getUserReviews(user_id);
    }
    
    @GET
    @Path("check_user")
    @Produces("application/json")
    /*
    *search user with email, phone, or username, check if user exist.
    *return 0 if no exist, otherwise 1.
    */
    public int check_user(
            @QueryParam("email") String email,
            @QueryParam("phone") String phone,
            @QueryParam("username") String username
    ){
        String k = "email_addr";
        String v = email;
        if(phone != null){
            k = "phone_numb";
            v = phone;
        }else if(username != null){
            k = "username";
            v = username;
        }              
        return searchClient.check_user(UserSqlBuilder.searchUserSql(k, v));
    }
    
    @GET
    @Path("verify_user")
    @Produces("application/json")
    //verify email
    public java.math.BigInteger verify_user(
            @QueryParam("email") String email,
            @QueryParam("password") String pw
    ){
        String sql = "select id, password from user where email_addr = \"" + email+"\"";
        return searchClient.verify_user(sql, pw);
    }
    
    @GET
    @Path("user/images/{id}")
    @Produces("application/json")
    public ArrayList<UserImage> getUserImage(
    @PathParam("id") String id
    ){
        return searchClient.getUserImages(id);
    }
    
}
