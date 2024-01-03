package com.grocerymanagement.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class CustomException {
    private String message;
    private HttpStatus httpStatus;
}
