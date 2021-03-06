package com.jts.consumer.config;

import com.jts.service.api.ClassService;
import com.jts.service.api.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.spring.ReferenceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration 3.0+
public class ReferenceConfiguration {
    @Bean
    //@DubboReference(version = "1.0.0",url = "dubbo://127.0.0.1:12345",check = false)
    @DubboReference(version = "1.0.0",check = false)
    public ReferenceBean<UserService> userService() {
        return new ReferenceBean();
    }

    @Bean
    //@DubboReference(version = "1.0.0",url = "dubbo://127.0.0.1:12345",check = false)
    @DubboReference(version = "1.0.0",check = false)
    public ReferenceBean<ClassService> classService() {
        return new ReferenceBean();
    }
}
