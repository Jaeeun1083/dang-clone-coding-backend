package com.daangn.common.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class InputFieldException extends BusinessException {

    protected static final String EMAIL = "email";
    protected static final String PASSWORD = "password";

    private final String field;

    public InputFieldException(String message, HttpStatus httpStatus, String field) {
        super(message, httpStatus);
        this.field = field;
    }

}
