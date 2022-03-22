package com.daangn.auth.controller;

import com.daangn.auth.dto.LoginRequestDto;
import com.daangn.auth.dto.TokenResponseDto;
import com.daangn.auth.service.AuthService;
import com.daangn.member.domain.Member;
import com.daangn.member.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/members")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signin")
    public ResponseEntity<TokenResponseDto> loginMember(@RequestBody @Valid LoginRequestDto loginRequestDTO) {
        return ResponseEntity.ok()
                .body(authService.loginMember(loginRequestDTO));
    }

    @PostMapping("/signup")
    public ResponseEntity<Member> createMember(@RequestBody MemberDto member) {
        authService.existsEmail(member.getEmail());
        return ResponseEntity.ok()
                .body(authService.createMember(member));
    }

}
