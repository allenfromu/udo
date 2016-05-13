/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udoojobs.rest;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.udoojobs.model.User;
import com.udoojobs.service.UpdateService;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author zepengzhao
 * 
 */

@Path("update")
public class UpdateResource {
    UpdateService updateService = new UpdateService();
        
    @Path("bio")
    @POST
    @JsonSerialize
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)    
    public String update_bio(User user){
        String str = "{\"status\":"+updateService.update_bio(user)+"}";
        return str;
    }
    
    
}
