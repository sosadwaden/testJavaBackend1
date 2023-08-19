package com.app.testtaskjavaback.exception;

public class UserExistingEmailException extends RuntimeException {
    public UserExistingEmailException(String message) {
        super(message);
    }

    public UserExistingEmailException(Throwable cause) {
        super(cause);
    }
}
