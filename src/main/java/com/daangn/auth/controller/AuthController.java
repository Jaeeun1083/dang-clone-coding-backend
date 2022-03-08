package com.daangn.auth.controller;

import com.daangn.auth.dto.LoginRequestDTO;
import com.daangn.auth.dto.TokenResponseDTO;
import com.daangn.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
@RequestMapping(value = "/api/members")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signin")
    public ResponseEntity<TokenResponseDTO> login(@RequestBody @Valid LoginRequestDTO loginRequestDTO) {
        return ResponseEntity.ok()
                .body(authService.login(loginRequestDTO));
    }
    
}