package com.jts.consumer.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(value = {Exception.class})
    @ResponseBody
    public String handle(Exception e){
        log.error("",e);
        return e.getMessage();
    }
}
