/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udoojobs.rest;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.udoojobs.model.User;
import com.udoojobs.service.DeleteService;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author zepengzhao
 * 
 */
@Path("delete")
public class DeleteResource {
    DeleteService deleteService = new DeleteService();
 
    @Path("job/{id}")
    @DELETE
    @JsonSerialize
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)    
    public String update_bio(@PathParam("id") String id){
        String str = "{\"status\":"+deleteService.delete_job(id)+"}";
        return str;
    }
    
    
    
    
}
