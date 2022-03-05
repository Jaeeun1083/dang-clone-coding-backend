package com.daangn.member.service;

import com.daangn.member.domain.Member;
import com.daangn.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void signup(Member member) {
        validateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member);
    }

    public void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findById(member.getId());
        // EXCEPTION
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }
}
