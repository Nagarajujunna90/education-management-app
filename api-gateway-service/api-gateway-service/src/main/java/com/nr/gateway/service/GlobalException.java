package com.nr.gateway.service;

import io.jsonwebtoken.security.SignatureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(SignatureException.class)
    public ResponseEntity<CustomError> userNotFoundException(SignatureException userNotFoundException) {
        CustomError customError = new CustomError(userNotFoundException.getMessage(), HttpStatus.UNAUTHORIZED.value(), LocalDateTime.now());
        return new ResponseEntity<>(customError, HttpStatus.UNAUTHORIZED);
    }
}
