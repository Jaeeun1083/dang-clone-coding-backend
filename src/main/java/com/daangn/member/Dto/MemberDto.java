package com.daangn.member.Dto;

import com.daangn.member.domain.Member;
import com.daangn.member.domain.MemberStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MemberDto {

    private Long id;

    private String email;

    private String password;

    private String nickName;

    private String imageUrl;

    private String status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public static Member memberDtoToEntity(MemberDto dto) {
        return Member.builder()
                .email(dto.getEmail())
                .password(dto.getPassword())
                .imageUrl(dto.getImageUrl())
                .nickName(dto.getNickName())
                .updatedAt(dto.getUpdatedAt())
                .status(MemberStatus.valueOf(dto.getStatus()))
                .build();
    }

}
