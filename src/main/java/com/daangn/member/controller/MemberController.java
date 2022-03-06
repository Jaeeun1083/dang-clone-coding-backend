package com.daangn.member.controller;

import com.daangn.member.Dto.MemberDto;
import com.daangn.member.repository.MemberRepository;
import com.daangn.member.service.MemberService;
import com.daangn.security.payload.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/members")
@RestController
public class MemberController {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    PasswordEncoder encoder;

    @PostMapping("/signup")
    public ResponseEntity<?> createUser(@RequestBody MemberDto member) {
        try {
                if (memberService.existsEmail(member.getEmail())) {
                    return ResponseEntity
                            .badRequest()
                            .body(new MessageResponse("Error: This Username already exists."));
                }
                if (!memberService.checkRange(member.getPassword())) {
                    return ResponseEntity
                            .badRequest()
                            .body(new MessageResponse("Error: The password must be between 6 and 40 characters."));
                }
                memberService.createMember(member);

            return ResponseEntity.ok(
                    new MessageResponse("Inserted or updated user entities."));
        } catch (Exception e) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Save Failed"));
        }
    }

}
