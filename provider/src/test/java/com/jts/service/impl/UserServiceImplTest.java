package com.jts.service.impl;

import com.alibaba.testable.core.annotation.MockDiagnose;
import com.alibaba.testable.core.annotation.MockMethod;
import com.alibaba.testable.core.model.LogLevel;
import com.alibaba.testable.core.tool.PrivateAccessor;
import com.alibaba.testable.core.tool.TestableTool;
import com.jts.service.api.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class UserServiceImplTest {

    UserService userService = new UserServiceImpl();

    @MockDiagnose(LogLevel.VERBOSE)
    public static class Mock{

        @MockMethod(targetClass = System.class)
        private long nanoTime() {
            return (long)TestableTool.MOCK_CONTEXT.get("nano");
        }

        @MockMethod(targetClass = UserServiceImpl.class)
        private String getUser(){
            return "123";
        }

        @MockMethod(targetClass = Context.class)
        private Object lookup(String str){
            return "lookup";
        }
    }

    @Test
    public void testGetUser(){
        TestableTool.MOCK_CONTEXT.put("nano",111L);
        PrivateAccessor.set(userService,"providerId","1");
        Assertions.assertEquals("1_111_User", userService.getUser());
    }

    @Test
    public void test(){
        TestableTool.MOCK_CONTEXT.put("nano",123L);
        try {
            System.out.println(userService.get());
        } catch (NamingException e) {
            e.printStackTrace();
            Assertions.assertTrue(Boolean.FALSE);
        }
    }
}
