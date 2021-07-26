package com.jts.consumer;

import com.jts.service.api.ClassService;
import com.jts.service.api.UserService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
@RestController
public class UserController {

        @DubboReference(version = "1.0.0",check = false)
        private UserService userService;

        @DubboReference(version = "1.0.0",check = false)
        private ClassService classService;

        private final RateLimiterOnSemaphore limiter = new RateLimiterOnSemaphore();

        @GetMapping("/getUser")
        public String getUser(){

                if(limiter.tryAcquire()){
                        log.info("invoke consumer getUser");
                        return userService.getUser();
                }else {
                        log.info("reject consumer getUser");
                        return "reject consumer getUser";
                }
        }

        @GetMapping("/getClz")
        public String getClz(){
                log.info("invoke consumer getClz");
                return classService.getClz();
        }



}
