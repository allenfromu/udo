/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udoojobs.sql.util;

import com.udoojobs.Enums.AuthoType;
import com.udoojobs.model.User;

/**
 *
 * @author zepengzhao
 */
public class UserSqlBuilder {
    
    public static String searchUserSql(String k, String v){
        String sql = "select id from user where " + k + "=\"" + v+"\"";
        return sql;
    }
    
    
    public static String createUserSql(User user){
        String sql = "insert into user(username,password,display_name,first_name,last_name, email_addr, "
                + "phone_numb, bio, street, city, state, country, zip_code,created_time, "
                + "autho_id, autho_type, profile_url) values(";
        sql += user.getUserName()==null?"NULL,":"\""+user.getUserName()+"\",";
        sql += user.getPassword()==null?"NULL,":"\""+user.getPassword()+"\",";
        sql += user.getDisplay_Name()==null?"NULL,":"\""+user.getDisplay_Name()+"\",";
        sql += user.getFirstName()==null?"NULL,":"\""+user.getFirstName()+"\",";
        sql += user.getLastName()==null?"NULL,":"\""+user.getLastName()+"\","; 
        sql += user.getEmail()==null?"NULL,":"\""+user.getEmail()+"\",";
        sql += user.getPhone()==null?"NULL,":"\""+user.getPhone()+"\",";
        sql += user.getBio()==null?"NULL,":"\""+user.getBio()+"\",";
        sql += user.getStreet()==null?"NULL,":"\""+user.getStreet()+"\",";
        sql += user.getCity()==null?"NULL,":"\""+user.getCity()+"\",";
        sql += user.getState()==null?"NULL,":"\""+user.getState()+"\",";
        sql += user.getCountry()==null?"NULL,":"\""+user.getCountry()+"\",";
        sql += user.getZipCode()==null?"NULL,":"\""+user.getZipCode()+"\",";
        sql += "NOW(),";
        sql += user.getAuthoID()+",";
        sql += user.getAuthoType()+",";
        sql += user.getProfileURL()==null?"NULL)":"\""+user.getProfileURL()+"\")";
        return sql;
    }
    
    
    
}
