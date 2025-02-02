package com.daangn.common.config;

import com.daangn.auth.handler.AuthenticationArgumentResolver;
import com.daangn.auth.handler.AuthenticationInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@RequiredArgsConstructor
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private final AuthenticationArgumentResolver authenticationArgumentResolver;
    private final AuthenticationInterceptor authenticationInterceptor;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(authenticationArgumentResolver);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> addPath = List.of(
                "api/**"
        );
        List<String> excludePath = List.of(
                "api/members/signin"
        );
        registry.addInterceptor(authenticationInterceptor)
                .addPathPatterns(addPath)
                .excludePathPatterns(excludePath);
    }

}
