/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udoojobs.guicetest;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.udoojobs.model.Review;
import com.udoojobs.model.User;
import org.junit.Test;

/**
 *
 * @author zepengzhao
 */
public class GuiceTest1 {
    @Test
    public void Test1(){
         Injector injector = Guice.createInjector();   
         Review review1 = injector.getInstance(Review.class);
         review1.setComment("This is my comment");
         Review review2 = injector.getInstance(Review.class);
         System.out.println(review1.getComment());
         review2.setComment("Comment changed by review 2");
         review2.setCountry("China");
         System.out.println(review1.getComment());        
    }
    @Test
    public void Test2(){
        
       Injector injector = Guice.createInjector(new AppInjector()); 
                Review review2 = injector.getInstance(Review.class);
         review2.setComment("Comment changed by review 2");
         review2.setCountry("China");
       System.out.println(injector.getInstance(User.class).getCountry());
       System.out.println(injector.getAllBindings().toString());
               
    }
    private class AppInjector extends AbstractModule {

        @Override
        protected void configure() {
            bind(User.class).to(Review.class);
        }
        
    }    
}
