package com.manoj.springcloud.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.httpBasic();

        httpSecurity.authorizeHttpRequests()
                .requestMatchers(HttpMethod.GET, "/couponapi/coupons/{code:^[A-Z]*$}")
                .hasAnyRole("USER", "ADMIN")
                .requestMatchers(HttpMethod.POST, "/couponapi/coupons")
                .hasRole("ADMIN")
                .and()
                .csrf().disable();

        return httpSecurity.build();
    }

}
