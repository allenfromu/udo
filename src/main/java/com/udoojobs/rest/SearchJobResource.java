/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udoojobs.rest;

import com.udoojobs.model.Job;
import com.udoojobs.service.SearchJobService;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author zepengzhao
 */
@Path("searchjob")
public class SearchJobResource {
    private final SearchJobService searchClient = new SearchJobService();
    //specific user id 
    @Context
    private UriInfo context;
    
    @GET
    @Path("jobs")
    @Produces("application/json")   
    public ArrayList<Job> getJobs(){
        return searchClient.getJobs();
    }

       
    
}
