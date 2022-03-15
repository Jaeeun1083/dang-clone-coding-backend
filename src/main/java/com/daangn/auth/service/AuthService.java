package com.daangn.auth.service;

import com.daangn.auth.dto.LoginRequestDTO;
import com.daangn.auth.dto.TokenResponseDTO;
import com.daangn.auth.util.TokenProvider;
import com.daangn.member.domain.Member;
import com.daangn.member.domain.MemberStatus;
import com.daangn.member.dto.MemberDto;
import com.daangn.member.exceptions.NotFoundMemberException;
import com.daangn.member.exceptions.NotMatchMemberException;
import com.daangn.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AuthService {

    private final TokenProvider tokenProvider;
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    public TokenResponseDTO login(LoginRequestDTO loginRequestDTO) {
        Member findMember = memberRepository.findByEmail(loginRequestDTO.getEmail())
                .orElseThrow(() -> new NotFoundMemberException());
        validatePassword(findMember, loginRequestDTO.getPassword());
        String token = createToken(findMember.getId());
        return new TokenResponseDTO(token);
    }

    private String createToken(Long id) {
        return tokenProvider.createToken(String.valueOf(id));
    }

    private void validatePassword(Member member, String password) {
        if (!passwordEncoder.matches(password, member.getPassword())) {
            throw new NotMatchMemberException();
        }
    }

    public Member createMember(MemberDto dto) {
        existsEmail(dto.getEmail());
        Member member = Member.builder()
               .email(dto.getEmail())
               .password(dto.getPassword())
               .imageUrl(dto.getImageUrl())
               .nickName(dto.getNickName())
               .status(MemberStatus.valueOf(dto.getStatus()))
               .build();
        memberRepository.save(member);
        return member;
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
