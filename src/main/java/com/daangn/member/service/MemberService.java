package com.daangn.member.service;

import com.daangn.member.Dto.MemberDto;
import com.daangn.member.domain.Member;
import com.daangn.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    public void createMember(MemberDto dto) {
        existsEmail(dto.getEmail());
        dto.setStatus("ACTIVATE");
        Member member = MemberDto.memberDtoToEntity(dto);
        memberRepository.save(member);
    }

    public Boolean existsEmail(String email) {
        return memberRepository.existsByEmail(email);
    }

    public boolean checkRange(String password) {
        if (password.length() < 6 || password.length() > 40) {
            return false;
        }
        return true;
    }

}
