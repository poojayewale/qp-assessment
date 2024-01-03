package com.grocerymanagement.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class InsufficientInventory extends RuntimeException{

    private HttpStatus httpStatus;
    public InsufficientInventory(String message, HttpStatus httpStatus){
        super(message);
        this.httpStatus=httpStatus;
    }
}
