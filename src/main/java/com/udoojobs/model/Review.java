/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udoojobs.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.inject.Singleton;
/**
 *
 * @author Felix
 */
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
@Singleton
public class Review extends User {
    private java.math.BigInteger id;
    private java.math.BigInteger to;
    private java.math.BigInteger from;
    private int rating;
    private String comment;
    private java.math.BigInteger application_id;
    
    public Review()
    {
        //default comment is empty string
        comment = "";
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
     * @return the user_id1
     */
    @JsonProperty("user_id1")
    public java.math.BigInteger getUserId1() {
        return to;
    }

    /**
     * @param user_id1 the user_id1 to set
     */
    @JsonProperty("user_id1")
    public void setUserId1(java.math.BigInteger user_id1) {
        this.to = user_id1;
    }

    /**
     * @return the user_id2
     */
    @JsonProperty("user_id2")
    public java.math.BigInteger getUserId2() {
        return from;
    }

    /**
     * @param user_id2 the user_id2 to set
     */
    @JsonProperty("user_id2")
    public void setUserId2(java.math.BigInteger user_id2) {
        this.from = user_id2;
    }

    /**
     * @return the rating
     */
    @JsonProperty("rating")
    public int getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
     @JsonProperty("rating")
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     * @return the comment
     */
     @JsonProperty("comment")
    public String getComment() {
        return comment;
    }

    /**
     * @param comment the comment to set
     */
    @JsonProperty("comment")
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * @return the application_id
     */
    @JsonProperty("application_id")
    public java.math.BigInteger getApplicationId() {
        return application_id;
    }

    /**
     * @param application_id the application_id to set
     */
    @JsonProperty("application_id")
    public void setApplicationId(java.math.BigInteger application_id) {
        this.application_id = application_id;
    }
    
    
}