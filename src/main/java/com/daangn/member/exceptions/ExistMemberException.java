package com.daangn.member.exceptions;

import com.daangn.common.exceptions.InputFieldException;
import org.springframework.http.HttpStatus;

public class ExistMemberException extends InputFieldException {

    private static final String MESSAGE = "이미 등록된 이메일 입니다.";

    public ExistMemberException() {
        super(MESSAGE, HttpStatus.BAD_REQUEST, PASSWORD);
    }
}
