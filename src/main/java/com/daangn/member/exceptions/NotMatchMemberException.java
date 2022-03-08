package com.daangn.member.exceptions;

import com.daangn.common.exceptions.InputFieldException;
import org.springframework.http.HttpStatus;

public class NotMatchMemberException extends InputFieldException {

    private static final String MESSAGE = "이메일 혹은 비밀번호를 확인해주세요.";

    public NotMatchMemberException() {
        super(MESSAGE, HttpStatus.BAD_REQUEST, PASSWORD);
    }

}
