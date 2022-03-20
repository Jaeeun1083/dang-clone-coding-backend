package com.daangn.auth.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class LoginRequestDTO {

    @NotBlank
    private String email;
    @NotBlank
    private String password;

    @Builder
    private LoginRequestDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

}
