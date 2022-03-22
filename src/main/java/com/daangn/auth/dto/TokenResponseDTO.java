package com.daangn.auth.dto;

import lombok.Getter;

@Getter
public class TokenResponseDto {

    private String token;

    public TokenResponseDto(String token) {
        this.token = token;
    }

    public static TokenResponseDto from(String token) {
        return new TokenResponseDto(token);
    }

}
