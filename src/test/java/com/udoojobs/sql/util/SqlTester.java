/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udoojobs.sql.util;

import com.google.inject.AbstractModule;
import com.udoojobs.model.Review;
import java.math.BigInteger;
import org.junit.Test;

/**
 *
 * @author zepengzhao
 */
public class SqlTester {
    @Test
    public void TestReviewSql(){
        Review r = new Review();
        r.setComment("he is good tutor");
        r.setUserId1(BigInteger.valueOf(9));
        r.setUserId2(BigInteger.valueOf(10));
        r.setRating(5);
        System.out.println(JobSqlBuilder.addReviewSql(r));
    }

}
