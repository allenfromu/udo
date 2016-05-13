/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udoojobs.rest;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.udoojobs.sql.util.UserSqlBuilder;
import com.udoojobs.model.User;
import com.udoojobs.service.PostUserService;
import com.udoojobs.service.SearchUserService;
import java.math.BigInteger;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author zepengzhao
 */
@Path("postuser")
public class PostUserResource {
    PostUserService postClient = new PostUserService();
    
    @Context
    private UriInfo context;

          
    @Path("add")
    @POST
    @JsonSerialize
    @Consumes("application/json")
    @Produces("application/json")
    public String createUser(User user){        
        long id = postClient.createUser(user);
        return "{\"status\":\"done!\"}";
    }
    
    @Path("verifyuser")
    @POST
    @JsonSerialize
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User verifyUser(User user)
    {
        /*ArrayList<User> users = new ArrayList<User>();
        users.add(postClient.verify_user(user.getEmail(), user.getPassword()));
        return users;*/
        return postClient.verify_user(user.getEmail(), user.getPassword());
    }

}
