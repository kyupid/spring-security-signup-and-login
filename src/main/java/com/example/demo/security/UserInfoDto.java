package com.example.demo.security;

import lombok.Data;

@Data
public class UserInfoDto {
    private String email;
    private String password;
    private String auth;
}
