package com.library.dtos;

import jakarta.validation.constraints.NotBlank;

public class loginDTO {

    @NotBlank(message = "Username is required")
    private String username;
    @NotBlank(message = "Password is required")
    private String password;
}
