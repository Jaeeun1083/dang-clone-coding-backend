package com.daangn.auth.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class TokenResponseDTO {

    private String token;

    @Builder
    public TokenResponseDTO(String token) {
        this.token = token;
    }

    public static TokenResponseDTO from(String token) {
        return new TokenResponseDTO(token);
    }
}
