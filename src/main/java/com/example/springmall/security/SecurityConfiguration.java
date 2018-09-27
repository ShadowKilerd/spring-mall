package com.example.springmall.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomBasicAuthenticationFilter customBasicAuthenticationFilter;

//
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
//                .httpBasic()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()  // stateless site
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .csrf().disable()
                .addFilterBefore(customBasicAuthenticationFilter, BasicAuthenticationFilter.class);
    }

}