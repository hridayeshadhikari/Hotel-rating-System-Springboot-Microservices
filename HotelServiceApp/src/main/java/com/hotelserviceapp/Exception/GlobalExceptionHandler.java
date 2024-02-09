package com.hotelserviceapp.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFound(ResourceNotFoundException exp){
        String message=exp.getMessage();
        ErrorDetails details=ErrorDetails.builder()
                .message(message)
                .success(true)
                .status(HttpStatus.NOT_FOUND)
                .timeStamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<ErrorDetails>(details,HttpStatus.NOT_FOUND);
    }
}
