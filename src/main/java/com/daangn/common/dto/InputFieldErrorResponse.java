package com.daangn.common.dto;

import com.daangn.common.exceptions.InputFieldException;
import lombok.Getter;

@Getter
public class InputFieldErrorResponse extends ErrorResponse {

    private String field;

    protected InputFieldErrorResponse(String message, String field) {
        super(message);
        this.field = field;
    }

    public static InputFieldErrorResponse from(InputFieldException exception) {
        return new InputFieldErrorResponse(exception.getMessage(), exception.getField());
    }

}
