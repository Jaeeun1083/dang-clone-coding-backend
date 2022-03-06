package com.daangn.member.domain;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Member extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String email;

    private String password;

    private String nickName;

    private String imageUrl;

    private double mannerTemperature = 36.5;

    @Enumerated(EnumType.STRING)
    private MemberStatus status;

    @Builder
    private Member(Long id, String email, String password, String nickName, String imageUrl, LocalDateTime updatedAt, MemberStatus status) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.nickName = nickName;
        this.imageUrl = imageUrl;
        this.updatedAt = updatedAt;
        this.status = status;
    }

}
