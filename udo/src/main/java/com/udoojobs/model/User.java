/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udoojobs.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;

/**
 *
 * @author zepengzhao
 */
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class User {
    private java.math.BigInteger id;
    private String username;
    private String password;
    private String display_name;
    private String first_name;
    private String last_name;
    private String bio;
    private String email;
    private String phone;
    private String street;
    private String city;
    private String state;
    private String country;
    private String zip_code;
    private java.sql.Timestamp created_time;
    private java.math.BigInteger autho_id;
    private int autho_type;
    private ArrayList<UserImage> user_images; 
    private String profile_url;
    private float average_rating;
    
    public  User(){
    };
    
    @JsonProperty("password")
    public void setPassword(String pw){
        this.password = pw;
    }
    
    @JsonProperty("password")
    public String getPassword(){
        return this.password;
    }
    @JsonProperty("average_rating")
    public void setAveRating(float av){
        this.average_rating = av;
    }
    
    @JsonProperty("average_rating")
    public float getAveRating(){
        return this.average_rating;
    }
    
    
    @JsonProperty("username")
    public void setUserName(String username){
        this.username = username;
    }
    
    @JsonProperty("username")
    public String getUserName(){
        return this.username;
    }
    
    @JsonProperty("first_name")
    public void setFirstName(String first_name){
        this.first_name = first_name;
    }
    
    @JsonProperty("first_name")
    public String getFirstName(){
        return this.first_name;
    }
    
    @JsonProperty("last_name")
    public void setLastName(String last_name){
       this.last_name = last_name;
    }
    
    @JsonProperty("last_name")
    public String getLastName(){
        return this.last_name;
    }
    
    @JsonProperty("bio")
    public String getBio(){
        return this.bio;
    }
    
    @JsonProperty("bio")
    public void setBio(String bio){
        this.bio = bio;
    }
    
    @JsonProperty("id")
    public void setID(java.math.BigInteger user_id){
        this.id = user_id;
    }
    
    @JsonProperty("id")
    public java.math.BigInteger getID(){
        return id;
    }
    
    @JsonProperty("display_name")
    public void setDisplay_Name(String display_name){
        this.display_name = display_name;
    }
    
    @JsonProperty("display_name")
    public String getDisplay_Name(){
        return this.display_name;
    }
    
     @JsonProperty("phone")
    public void setPhone(String phone){
        this.phone = phone;
    }
    
    @JsonProperty("phone")
    public String getPhone(){
        return this.phone;
    }
    
    @JsonProperty("email")
    public void setEmail(String email){
        this.email = email;
    }
    
    @JsonProperty("email")
    public String getEmail(){
        return this.email;
    }
    
    @JsonProperty("street")
    public void setStreet(String street){
        this.street = street;
    }
    
    @JsonProperty("street")
    public String getStreet(){
        return this.street;
    }
    
    @JsonProperty("city")
    public void setCity(String city){
       this.city = city;
    }
    
    @JsonProperty("city")
    public String getCity(){
        return this.city;
    }
    
    @JsonProperty("state")
    public void setState(String state){
       this.state = state;
    }
    
    @JsonProperty("state")
    public String getState(){
        return this.state;
    }
    
    @JsonProperty("country")
    public void setCountry(String country){
       this.country = country;
    }
    
    @JsonProperty("country")
    public String getCountry(){
        return this.country;
    }
    
    @JsonProperty("zip_code")
    public void setZipCode(String zip_code){
       this.zip_code = zip_code;
    }
    
    @JsonProperty("zip_code")
    public String getZipCode(){
        return this.zip_code;
    }
    
    @JsonProperty("created_time")
    public void setCreatedTime(java.sql.Timestamp created_time){
        this.created_time = created_time;
       
    }
    
    @JsonProperty("created_time")
    public java.sql.Timestamp getCreatedTime(){
        return this.created_time;
    }
    
    @JsonProperty("autho_id")
    public void setAuthoID(java.math.BigInteger autho_id){
        this.autho_id = autho_id;
       
    }
    
    @JsonProperty("autho_id")
    public java.math.BigInteger getAuthoID(){
        return this.autho_id;
    }
    
    @JsonProperty("autho_type")
    public void setAuthoType(int type){
       this.autho_type = type;
    }
    
    @JsonProperty("autho_type")
    public int getAuthoType(){
        return this.autho_type;
    }

    /**
     * @return the user_images
     */
    @JsonProperty("user_images")
    public ArrayList<UserImage> getUserImage() {
        return user_images;
    }

    /**
     * @param user_images the user_images to set
     */
    @JsonProperty("user_images")
    public void setUserImage(ArrayList<UserImage> user_images) {
        this.user_images = user_images;
    }
    
    /**
     * @return the user_images
     */
    @JsonProperty("profile_url")
    public String getProfileURL() {
        return profile_url;
    }

    /**
     * @param user_images the user_images to set
     */
    @JsonProperty("profile_url")
    public void setProfileURL(String user_image) {
        this.profile_url = user_image;
    }
    
    
}