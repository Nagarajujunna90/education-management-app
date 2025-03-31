package com.nr.student.exception;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
public record ErrorResponse(
        @JsonProperty("errorMessage") String errorMessage,
        @JsonProperty("errorCode") int errorCode,
        @JsonProperty("timeStamp") LocalDateTime timestamp
) {}

