package com.raduq.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class MarsExceptionHandler {
    
    private Logger logger = LoggerFactory.getLogger(getClass());
 
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MarsException.class)
    @ResponseBody
    public String marsException(Exception e) {
        logger.error(e.getMessage(), e);
        return e.getMessage();
    }

}
