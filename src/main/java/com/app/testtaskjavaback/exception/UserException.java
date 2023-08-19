package com.app.testtaskjavaback.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Data
public class UserException {
    private final String MESSAGE;
    private final Throwable THROWABLE;
    private final HttpStatus httpStatus;
}
