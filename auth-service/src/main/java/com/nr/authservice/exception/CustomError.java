package com.nr.authservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Setter
@Getter
@AllArgsConstructor
public class CustomError {

    private String errorMessage;
    private int errorCode;
    private LocalDateTime timeStamp;

}
