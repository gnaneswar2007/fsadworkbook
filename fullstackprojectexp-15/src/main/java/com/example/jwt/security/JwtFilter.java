package com.example.jwt.security;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JwtFilter extends GenericFilter {

@Autowired
JwtUtil jwtUtil;

@Override
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {

    HttpServletRequest req = (HttpServletRequest) request;

    String header = req.getHeader("Authorization");

    if(header != null && header.startsWith("Bearer ")){

        String token = header.substring(7);

        String username = jwtUtil.extractUsername(token);

        System.out.println("Authenticated User: "+username);
    }

    chain.doFilter(request,response);
}
}