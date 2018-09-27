package com.example.springmall.security;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class CustomBasicAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String userDetail = request.getHeader("X-user-detail");
        System.out.println("userDetail" + userDetail);

        JsonNode userDetailNode = objectMapper.reader().readTree(userDetail);
        String userId = userDetailNode.get("userId").toString();
        userId = userId.substring(1, userId.length() - 1);


        List<GrantedAuthority> roles = new ArrayList<>();

        Iterator<JsonNode> rolesNode = userDetailNode.get("roles").iterator();
        while (rolesNode.hasNext()) {
            String role = rolesNode.next().toString();

            roles.add(new SimpleGrantedAuthority(role.substring(1, role.length() - 1)));
        }


        CustomizedAuthenticationToken token = new CustomizedAuthenticationToken(userId, roles);
        SecurityContextHolder.getContext().setAuthentication(token);
        filterChain.doFilter(request, response);
    }
}
