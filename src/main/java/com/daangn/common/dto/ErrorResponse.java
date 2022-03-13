package com.daangn.common.dto;

import lombok.Getter;

@Getter
public class ErrorResponse {

    private String message;

    protected ErrorResponse(final String message) {
        this.message = message;
    }

    public static ErrorResponse from(RuntimeException exception) {
        return new ErrorResponse(exception.getMessage());
    }

}
