package com.jts.service.impl;

import com.jts.service.api.ClassService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.StringJoiner;

@Slf4j
@DubboService(version = "1.0.0")
public class ClassServiceImpl implements ClassService {

    @Override
    public String getClz() {
        log.info("invoke provider getClz");
        StringJoiner res = new StringJoiner("_")
                .add(String.valueOf(System.nanoTime()))
                .add("Class");
        return res.toString();
    }
}
