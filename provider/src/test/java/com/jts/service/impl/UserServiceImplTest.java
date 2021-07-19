package com.jts.service.impl;

import com.alibaba.testable.core.annotation.MockDiagnose;
import com.alibaba.testable.core.annotation.MockMethod;
import com.alibaba.testable.core.model.LogLevel;
import com.alibaba.testable.core.tool.PrivateAccessor;
import com.jts.service.api.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserServiceImplTest {

    UserService userService = new UserServiceImpl();

    @MockDiagnose(LogLevel.VERBOSE)
    public static class Mock{

        @MockMethod(targetClass = System.class)
        private long nanoTime() {
            return 111L;
        }
    }

    @Test
    public void testGetUser(){

        PrivateAccessor.set(userService,"providerId","1");
        Assertions.assertEquals("1_111_User", userService.getUser());
    }

}
