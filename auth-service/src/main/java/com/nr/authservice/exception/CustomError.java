package com.nr.authservice.exception;

import java.time.LocalDateTime;

public record CustomError(String errorMessage, int errorCode, LocalDateTime timeStamp) {}
