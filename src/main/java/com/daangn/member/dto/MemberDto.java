package com.daangn.member.dto;

import com.daangn.member.domain.Member;
import com.daangn.member.domain.MemberStatus;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class MemberDto {

    private Long id;

    private String email;

    private String password;

    private String nickName;

    private String imageUrl;

    private String status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @Builder
    public MemberDto(MemberDto dto) {
       this.email = dto.getEmail();
       this.password = dto.getPassword();
       this.imageUrl = dto.getImageUrl();
       this.status = dto.getStatus();
       this.nickName = dto.getNickName();
       this.updatedAt = dto.getUpdatedAt();
    }

}
