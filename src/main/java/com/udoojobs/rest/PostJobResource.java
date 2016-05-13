/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udoojobs.rest;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.udoojobs.model.Job;
import com.udoojobs.model.Review;
import com.udoojobs.model.User;
import com.udoojobs.service.PostJobService;
import com.udoojobs.service.PostUserService;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author zepengzhao
 */
@Path("postjob")
public class PostJobResource {
     PostJobService postClient = new PostJobService();
    
    @Context
    private UriInfo context;

    @Path("add")
    @POST
    @JsonSerialize
    @Consumes("application/json")
    @Produces("application/json")
    public Job createUser(Job job){        
        return postClient.createJob(job);
    }   
    
    @Path("add_review")
    @POST
    @JsonSerialize
    @Consumes("application/json")
    @Produces("application/json")
    public Review addReview(Review r){        
        return postClient.addReview(r);
    }
    
    
}
