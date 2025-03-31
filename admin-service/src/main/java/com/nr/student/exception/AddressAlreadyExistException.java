package com.nr.student.exception;

public class AddressAlreadyExistException extends RuntimeException {
    public AddressAlreadyExistException(String message) {
        super(message);
    }
}
