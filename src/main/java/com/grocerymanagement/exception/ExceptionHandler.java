package com.grocerymanagement.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(InsufficientInventory.class)
    ResponseEntity<CustomException> handleEmployeeException(InsufficientInventory insufficientInventory){
        CustomException customException=new CustomException(insufficientInventory.getMessage(),insufficientInventory.getHttpStatus());
        return ResponseEntity.ok(customException);
    }
}
