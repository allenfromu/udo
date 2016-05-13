/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udoojobs.rest;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author zepengzhao
 */
@ApplicationPath("/api/*")
public class MyApplication extends Application{
    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(SearchUserResource.class);
        classes.add(PostUserResource.class);
        classes.add(SearchJobResource.class);
        classes.add(PostJobResource.class);
        classes.add(UpdateResource.class);
        classes.add(DeleteResource.class);
        return classes;
    }
    
}
