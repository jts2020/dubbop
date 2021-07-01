package com.jts.service.impl;

import com.jts.service.api.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;

@Slf4j
@DubboService(version = "1.0.0")
public class UserServiceImpl implements UserService {
    @Override
    public String getUser() {
        log.info("invoke getUser");
        return "User";
    }
}
