package com.example.cpimgroup.security.service.imple;

import com.example.cpimgroup.entities.Usuario;
import com.example.cpimgroup.security.dto.JwtResponseDto;


import com.example.cpimgroup.security.exceptions.JwtAuthenticationException;

import com.example.cpimgroup.security.security.JwtGenerator;
import com.example.cpimgroup.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;



@Service
public class UserServiceImple implements UserService {
  
   
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtGenerator jwtGenerator;

   
    
 
    @Override
    public JwtResponseDto login(Usuario loginDto) {
    	
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginDto.getEmail(),
                            loginDto.getPassword()
                    )
            );
       
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = jwtGenerator.generateToken(authentication);
            return new JwtResponseDto(token);
        } catch (AuthenticationException e) {
            throw new JwtAuthenticationException("Credenciales inválidas");
        }
    }

}