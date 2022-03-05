package com.daangn.member.controller;

import com.daangn.member.domain.Member;
import com.daangn.member.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class MemberController {

    @Autowired
    MemberService memberService;

    @PostMapping("member")
    public void signup(Member member) {
        memberService.signup(member);
    }
}
