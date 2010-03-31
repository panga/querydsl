/*
 * Copyright (c) 2010 Mysema Ltd.
 * All rights reserved.
 * 
 */
package com.mysema.query.types;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.mysema.query.types.expr.EString;
import com.mysema.query.types.expr.EStringConst;


public class EStringConstTest {

    @Test
    public void test(){
        assertEquals("abc", expr("ab").append("c").toString());
        assertEquals("abc", expr("bc").prepend("a").toString());
        assertEquals("abc", expr("ABC").lower().toString());
        assertEquals("ABC", expr("abc").upper().toString());
        assertEquals("ab",  expr("abc").substring(0,2).toString());
    }
    
    @Test
    public void test2(){
        assertEquals("abc", expr("ab").append(expr("c")).toString());
        assertEquals("abc", expr("bc").prepend(expr("a")).toString());
        assertEquals("abc", expr("ABC").lower().toString());
        assertEquals("ABC", expr("abc").upper().toString());
        assertEquals("ab",  expr("abc").substring(0,2).toString());
    }
    
    private EString expr(String str){
        return EStringConst.create(str);
    }
}