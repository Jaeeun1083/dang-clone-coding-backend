package com.daangn.auth.util;

import com.daangn.auth.exceptions.AuthorizationUninvolvedException;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

public class AuthorizationExtractor {

    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static String BEARER_TYPE = "Bearer ";

    public static String getTokenFromRequset(HttpServletRequest request) {
        String bearerToken = request.getHeader(AUTHORIZATION_HEADER);
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(BEARER_TYPE)) {
            return bearerToken.substring(BEARER_TYPE.length());
        }
        throw new AuthorizationUninvolvedException();
    }

}
