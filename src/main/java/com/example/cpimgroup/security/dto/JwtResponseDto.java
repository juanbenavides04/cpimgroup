package com.example.cpimgroup.security.dto;




public class JwtResponseDto {

    private String accessToken;
    public JwtResponseDto(String accessToken){
        this.accessToken = accessToken;
    }

    public JwtResponseDto(){}

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

}
