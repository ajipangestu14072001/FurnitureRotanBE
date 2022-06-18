package com.example.furniturerotanbe.payload.request;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class LoginRequest {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

}
