package com.app.testtaskjavaback.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(Throwable throwable) {
        super(throwable);
    }
}
