package com.nr.student.exception;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorResponse {
    private int status;
    private String errorMessage;
    private LocalDateTime timeStamp;

}
