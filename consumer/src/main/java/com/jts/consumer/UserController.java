package com.jts.consumer;

import com.jts.service.api.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class UserController {

        private UserService userService;

        public UserController(UserService userService) {
                this.userService = userService;
        }

        @GetMapping("/getUser")
        public String getUser(){
                log.info("invoke consumer getUser");
                return userService.getUser();
        }
}
