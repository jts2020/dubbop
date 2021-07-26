package com.jts.service.impl;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.jts.service.api.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.StringJoiner;

@Slf4j
@DubboService(version = "1.0.0")
public class UserServiceImpl implements UserService {

    @NacosValue(value = "${provider.id}", autoRefreshed = true)
    private String providerId = null;

    @Override
        public String getUser() {
        log.info("invoke provider getUser");
        StringJoiner res = new StringJoiner("_")
                .add(providerId)
                .add(String.valueOf(System.nanoTime()))
                .add("User");
        return res.toString();
    }

    @Override
    public String get(){
        return getUser();
    }
}
