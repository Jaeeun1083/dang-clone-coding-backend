package com.daangn.auth.exceptions;

import com.daangn.common.exceptions.BusinessException;
import org.springframework.http.HttpStatus;

public class TokenExpiredException extends BusinessException {

    private static final String MESSAGE = "로그인이 필요합니다.";

    public TokenExpiredException() {
        super(MESSAGE, HttpStatus.UNAUTHORIZED);
    }
}
