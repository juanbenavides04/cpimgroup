package com.example.cpimgroup.security.exceptions;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;

// errores tipo jwt errores de autenticacion de credenciales
public class JwtAuthenticationException extends AuthenticationCredentialsNotFoundException {
    //private static final long serialVersionUID = 2;

    public JwtAuthenticationException(String message){
        super(message);
    }
}
