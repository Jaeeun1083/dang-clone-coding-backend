package com.daangn.member.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MemberTest {

    @Test
    void newMember() {
        String email = "test@test.com";
        String password = "12345678";
        String nickName = "당근";
        String imageUrl = "http://image.com";
        MemberStatus status = MemberStatus.ACTIVATE;
        double defaultMannerTemperature = 36.5;

        Member member = Member.builder()
                .email(email)
                .password(password)
                .nickName(nickName)
                .imageUrl(imageUrl)
                .status(status)
                .build();

        assertThat(member.getEmail()).isEqualTo(email);
        assertThat(member.getPassword()).isEqualTo(password);
        assertThat(member.getNickName()).isEqualTo(nickName);
        assertThat(member.getImageUrl()).isEqualTo(imageUrl);
        assertThat(member.getStatus()).isEqualTo(status);
        assertThat(member.getMannerTemperature()).isEqualTo(defaultMannerTemperature);
    }
}
