package com.daangn.common.advice;

import com.daangn.common.dto.ErrorResponse;
import com.daangn.common.dto.InputFieldErrorResponse;
import com.daangn.common.exceptions.BusinessException;
import com.daangn.common.exceptions.InputFieldException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CommonAdvice {

    private final Logger LOG = LoggerFactory.getLogger(CommonAdvice.class);

    @ExceptionHandler(InputFieldException.class)
    public ResponseEntity<InputFieldErrorResponse> inputFieldExceptionHandler(final InputFieldException exception) {
        LOG.error(exception.getMessage());
        return ResponseEntity
                .status(exception.getHttpStatus())
                .body(InputFieldErrorResponse.from(exception));
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> businessExceptionHandler(final BusinessException exception) {
        LOG.error(exception.getMessage());
        return ResponseEntity
                .status(exception.getHttpStatus())
                .body(ErrorResponse.from(exception));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Void> unhandledExceptionHandler(final Exception exception) {
        LOG.warn(exception.getMessage(), exception);
        return ResponseEntity.internalServerError().build();
    }

}
