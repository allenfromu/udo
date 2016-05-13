/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udoojobs.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Timestamp;
import java.util.ArrayList;


/**
 *
 * @author Felix
 */
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class Job {
    private java.math.BigInteger id;
    private java.math.BigInteger user_id;
    private String title;
    private String desc;
    private Timestamp post_time;
    private int status;
    private Timestamp start_time;
    private Timestamp exp_time;
    private String street;
    private String city;
    private String state;
    private String country;
    private String zip_code;
    private java.math.BigDecimal geolng;
    private java.math.BigDecimal geolat;
    private int pay_type;
    private java.math.BigDecimal pay_amount;
    private ArrayList<Integer> job_category_ids;
    private ArrayList<JobImage> job_images;
    
    public Job()
    {
        //default status is 0 for pending
        status = 0;
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
     * @return the user_id
     */
    @JsonProperty("user_id")
    public java.math.BigInteger getUserId() {
        return user_id;
    }

    /**
     * @param user_id the user_id to set
     */
    @JsonProperty("user_id")
    public void setUserId(java.math.BigInteger user_id) {
        this.user_id = user_id;
    }

    /**
     * @return the title
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the desc
     */
    @JsonProperty("desc")
    public String getDesc() {
        return desc;
    }

    /**
     * @param desc the desc to set
     */
    @JsonProperty("desc")
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * @return the post_time
     */
    @JsonProperty("post_time")
    public Timestamp getPostTime() {
        return post_time;
    }

    /**
     * @param post_time the post_time to set
     */
    @JsonProperty("post_time")
    public void setPostTime(Timestamp post_time) {
        this.post_time = post_time;
    }

    /**
     * @return the status
     */
    @JsonProperty("status")
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    @JsonProperty("status")
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @return the start_time
     */
    @JsonProperty("start_time")
    public Timestamp getStartTime() {
        return start_time;
    }

    /**
     * @param start_time the start_time to set
     */
    @JsonProperty("start_time")
    public void setStartTime(Timestamp start_time) {
        this.start_time = start_time;
    }

    /**
     * @return the exp_time
     */
    @JsonProperty("exp_time")
    public Timestamp getExpTime() {
        return exp_time;
    }

    /**
     * @param exp_time the exp_time to set
     */
    @JsonProperty("exp_time")
    public void setExpTime(Timestamp exp_time) {
        this.exp_time = exp_time;
    }

    /**
     * @return the street
     */
    @JsonProperty("street")
    public String getStreet() {
        return street;
    }

    /**
     * @param street the street to set
     */
    @JsonProperty("street")
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * @return the city
     */
    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the state
     */
    @JsonProperty("state")
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the country
     */
    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return the zip_code
     */
    @JsonProperty("zip_code")
    public String getZipCode() {
        return zip_code;
    }

    /**
     * @param zip_code the zip_code to set
     */
    @JsonProperty("zip_code")
    public void setZipCode(String zip_code) {
        this.zip_code = zip_code;
    }

    /**
     * @return the geolng
     */
    @JsonProperty("geolng")
    public java.math.BigDecimal getGeolng() {
        return geolng;
    }

    /**
     * @param geolng the geolng to set
     */
    @JsonProperty("geolng")
    public void setGeolng(java.math.BigDecimal geolng) {
        this.geolng = geolng;
    }

    /**
     * @return the geolat
     */
    @JsonProperty("geolat")
    public java.math.BigDecimal getGeolat() {
        return geolat;
    }

    /**
     * @param geolat the geolat to set
     */
    @JsonProperty("geolat")
    public void setGeolat(java.math.BigDecimal geolat) {
        this.geolat = geolat;
    }

    /**
     * @return the pay_type
     */
    @JsonProperty("pay_type")
    public int getPayType() {
        return pay_type;
    }

    /**
     * @param pay_type the pay_type to set
     */
    @JsonProperty("pay_type")
    public void setPayType(int pay_type) {
        this.pay_type = pay_type;
    }

    /**
     * @return the pay_amount
     */
    @JsonProperty("pay_amount")
    public java.math.BigDecimal getPayment() {
        return pay_amount;
    }

    /**
     * @param pay_amount the pay_amount to set
     */
    @JsonProperty("pay_amount")
    public void setPayment(java.math.BigDecimal pay_amount) {
        this.pay_amount = pay_amount;
    }

    /**
     * @return the job_categories
     */
    @JsonProperty("job_categories")
    public ArrayList<Integer> getJobCategories() {
        return job_category_ids;
    }

    /**
     * @param job_categories the job_categories to set
     */
    @JsonProperty("job_categories")
    public void setJobCategories(ArrayList<Integer> jcs) {
        this.job_category_ids = jcs;
    }

    /**
     * @return the job_images
     */
    @JsonProperty("job_images")
    public ArrayList<JobImage> getJobImages() {
        return job_images;
    }

    /**
     * @param job_images the job_images to set
     */
    @JsonProperty("job_images")
    public void setJobImages(ArrayList<JobImage> job_images) {
        this.job_images = job_images;
    }
    
    
    
    
}