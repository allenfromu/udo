/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udoojobs.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
/**
 *
 * @author Felix
 */
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class JobImage {
    private java.math.BigInteger id;
    private java.math.BigInteger job_id;
    private java.sql.Timestamp created_time;
    private String url;
    
    public JobImage()
    {
        
    }

    /**
     * @return the id
     */
    @JsonProperty("id")
    public java.math.BigInteger getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    @JsonProperty("id")
    public void setId(java.math.BigInteger id) {
        this.id = id;
    }

    /**
     * @return the job_id
     */
    @JsonProperty("job_id")
    public java.math.BigInteger getJob_id() {
        return job_id;
    }

    /**
     * @param job_id the job_id to set
     */
    @JsonProperty("job_id")
    public void setJob_id(java.math.BigInteger job_id) {
        this.job_id = job_id;
    }

    /**
     * @return the url
     */
    @JsonProperty("image_url")
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    @JsonProperty("image_url")
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the created_time
     */
    public java.sql.Timestamp getCreated_time() {
        return created_time;
    }

    /**
     * @param created_time the created_time to set
     */
    public void setCreated_time(java.sql.Timestamp created_time) {
        this.created_time = created_time;
    }
    
    
}