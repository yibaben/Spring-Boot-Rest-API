package com.yibaben.SpringBootRestAPI.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException{
    private String resourceName;
    private String fieldName;
    private Long fieldValue;

    public UserNotFoundException(String resourceName, String fieldName, Long fieldValue) {
        super(String.format("%s Not Found With %s : '%s'", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
