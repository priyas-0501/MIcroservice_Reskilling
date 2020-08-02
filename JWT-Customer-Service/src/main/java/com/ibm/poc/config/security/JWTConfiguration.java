package com.ibm.poc.config.security;

import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class JWTConfiguration extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private TokenService tokenservice;

    public JWTConfiguration(TokenService tokenservice) {
        this.tokenservice = tokenservice;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
    	JWTFilter customFilter = new JWTFilter(tokenservice);
        http.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);
    }
}