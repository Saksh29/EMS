package com.practice.fistproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The class ResourceNotFoundException extends RuntimeException and sets the HTTP status code to
 * NOT_FOUND.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
     
    public ResourceNotFoundException(String message){
        super(message);
    }
}
