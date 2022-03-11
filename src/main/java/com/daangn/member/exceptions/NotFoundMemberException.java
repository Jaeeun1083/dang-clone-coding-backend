package com.daangn.member.exceptions;

import com.daangn.common.exceptions.InputFieldException;
import org.springframework.http.HttpStatus;

public class NotFoundMemberException extends InputFieldException {

    private static final String MESSAGE = "존재하지 않는 회원입니다.";

    public NotFoundMemberException() {
        super(MESSAGE, HttpStatus.NOT_FOUND, EMAIL);
    }
    
}
