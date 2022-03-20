package com.daangn.auth.controller;

import com.daangn.auth.dto.LoginRequestDTO;
import com.daangn.auth.dto.TokenResponseDTO;
import com.daangn.auth.service.AuthService;
import com.daangn.auth.util.TokenProvider;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AuthController.class)
class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthService authService;

    @MockBean
    private TokenProvider tokenProvider;

    @Autowired
    private ObjectMapper objectMapper;

    LoginRequestDTO loginRequestDTO;

    @BeforeEach
    void setup() {
        loginRequestDTO = LoginRequestDTO.builder()
                .email("test@test.com")
                .password("12345678")
                .build();
    }

    @Test
    void 로그인_성공() throws Exception {
        given(authService.login(any(LoginRequestDTO.class)))
                .willReturn(TokenResponseDTO.builder()
                        .token("1.2.3")
                        .build());

        mockMvc.perform(post("/api/members/signin")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(loginRequestDTO)))
                .andExpect(status().isOk());
    }

}