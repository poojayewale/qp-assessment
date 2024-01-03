package com.example.vehicle.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class CustomException {
    private String message;
    private HttpStatus httpStatus;
}
