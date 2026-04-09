package com.example.jwt.controller;

import com.example.jwt.dto.AuthRequest;
import com.example.jwt.security.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

@Autowired
JwtUtil jwtUtil;

@PostMapping("/login")
public String login(@RequestBody AuthRequest request){

    return jwtUtil.generateToken(request.getUsername());

}
}