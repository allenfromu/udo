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
public class UserImage {
    private java.math.BigInteger id;
    private java.math.BigInteger user_id;
    private java.sql.Timestamp created_time;
    private int type;   
    private String url;
    
    public UserImage()
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
    @JsonProperty("user_id")
    public java.math.BigInteger getUserId() {
        return user_id;
    }

    /**
     * @param job_id the job_id to set
     */
    @JsonProperty("user_id")
    public void setUserId(java.math.BigInteger user_id) {
        this.user_id = user_id;
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
    @JsonProperty("created_time")
    public java.sql.Timestamp getCreatedTime() {
        return created_time;
    }

    /**
     * @param created_time the created_time to set
     */
    @JsonProperty("created_time")
    public void setCreatedTime(java.sql.Timestamp created_time) {
        this.created_time = created_time;
    }

    /**
     * @return the type
     */
    @JsonProperty("type")
    public int getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    @JsonProperty("type")
    public void setType(int type) {
        this.type = type;
    }
    
    
    
}