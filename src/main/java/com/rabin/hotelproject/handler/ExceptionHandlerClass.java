package com.rabin.hotelproject.handler;

import com.rabin.hotelproject.exception.EmailAlreadyExistException;
import com.rabin.hotelproject.exception.InternalServerErrorException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandlerClass {

    @ExceptionHandler(EmailAlreadyExistException.class)
    public ResponseEntity<Map<String, String>> exceptionHandlingIfEmailAlreadyExistException(EmailAlreadyExistException ex) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("message", ex.getMessage());
        errorMap.put("status", HttpStatus.ALREADY_REPORTED.toString());
        return ResponseEntity.ok(errorMap);
    }


    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity<Map<String, String>> exceptionHandlingIfInternalServerErrorException(InternalServerErrorException ex) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("message", ex.getMessage());
        errorMap.put("status", HttpStatus.INTERNAL_SERVER_ERROR.toString());
        return ResponseEntity.ok(errorMap);
    }
}
