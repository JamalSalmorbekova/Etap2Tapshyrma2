package com.company.exceptions;

public class InvalidStartDrivingException extends RuntimeException{
    public InvalidStartDrivingException() {
    }

    public InvalidStartDrivingException(String message) {
        super(message);
    }
}
