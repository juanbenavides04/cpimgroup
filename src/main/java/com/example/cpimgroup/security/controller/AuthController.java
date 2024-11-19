package com.example.cpimgroup.security.controller;

import com.example.cpimgroup.entities.Usuario;
import com.example.cpimgroup.security.dto.JwtResponseDto;

import com.example.cpimgroup.security.security.JwtGenerator;
import com.example.cpimgroup.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private UserService userService;



    @PostMapping("/login")
    public ResponseEntity<JwtResponseDto> login(@RequestBody Usuario loginDto) {
        return ResponseEntity.ok(userService.login(loginDto));
    }


/*
    @PostMapping("/refresh-token")
    public ResponseEntity<?> refreshToke(Authentication authentication){

        String token = jwtGenerator.refreshToken(authentication);

        JwtResponseDto jwtRefresh = new JwtResponseDto(token);
        return new ResponseEntity<JwtResponseDto>(jwtRefresh, HttpStatus.OK);
    }
    */
}
