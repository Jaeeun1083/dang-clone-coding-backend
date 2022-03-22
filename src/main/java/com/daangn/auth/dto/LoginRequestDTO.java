package com.daangn.auth.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class LoginRequestDto {

    @NotBlank
    private String email;
    @NotBlank
    private String password;

    @Builder
    private LoginRequestDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

}
