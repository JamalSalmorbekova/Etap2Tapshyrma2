package com.company.exceptions;

public class InvalidChangeDriverException extends RuntimeException{
    public InvalidChangeDriverException() {
    }

    public InvalidChangeDriverException(String message) {
        super(message);
    }
}
