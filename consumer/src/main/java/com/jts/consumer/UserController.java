package com.jts.consumer;

import com.jts.service.api.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

        private UserService userService;

        public UserController(UserService userService) {
                this.userService = userService;
        }

        @GetMapping("/getUser")
        public String getUser(){
                return userService.getUser();
        }
}
