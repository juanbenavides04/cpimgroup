package com.example.cpimgroup.security.service;

import com.example.cpimgroup.entities.Usuario;
import com.example.cpimgroup.security.dto.JwtResponseDto;
public interface UserService {

  
    public JwtResponseDto login(Usuario loginDto);
}
