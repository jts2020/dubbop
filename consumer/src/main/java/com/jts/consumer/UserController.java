package com.jts.consumer;

import com.jts.service.api.ClassService;
import com.jts.service.api.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class UserController {

        private UserService userService;

        private ClassService classService;

        public UserController(UserService userService,ClassService classService) {
                this.userService = userService;
                this.classService = classService;
        }

        @GetMapping("/getUser")
        public String getUser(){
                log.info("invoke consumer getUser");
                return userService.getUser();
        }

        @GetMapping("/getClz")
        public String getClz(){
                log.info("invoke consumer getClz");
                return classService.getClz();
        }
}
