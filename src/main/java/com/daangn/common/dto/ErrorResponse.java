package com.daangn.common.dto;

public class ErrorResponse {
    
    private String message;

    protected ErrorResponse(final String message) {
        this.message = message;
    }

    public static ErrorResponse from(final RuntimeException exception) {
        return new ErrorResponse(exception.getMessage());
    }

}
