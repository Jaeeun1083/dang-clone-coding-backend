package com.daangn.auth.controller;

import com.daangn.auth.dto.LoginRequestDTO;
import com.daangn.auth.dto.TokenResponseDTO;
import com.daangn.auth.service.AuthService;
import com.daangn.member.domain.Member;
import com.daangn.member.dto.MemberDto;
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

    @PostMapping("/signup")
    public ResponseEntity<Member> createUser(@RequestBody MemberDto member) {
        authService.existsEmail(member.getEmail());
        return ResponseEntity.ok()
                .body(authService.createMember(member));
    }

}
