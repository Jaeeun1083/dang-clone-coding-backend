package com.daangn.member.service;

import com.daangn.member.Dto.MemberDto;
import com.daangn.member.repository.MemberRepository;
import org.junit.jupiter.api.Test;

class MemberServiceTest {
    MemberService memberService = new MemberService();

    MemberRepository memberRepository;

     @Test
     private void 회원가입() throws Exception {
         //given
         MemberDto member = new MemberDto();
                 member.setEmail("test@test.com");
                 member.setPassword("12345678");
                 member.setNickName("당근");

         //when
         memberService.createMember(member);

         //then
        System.out.println(member);
     }
}