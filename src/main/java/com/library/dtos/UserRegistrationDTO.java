package com.library.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegistrationDTO {
    @NotBlank(message = "username is required")
    private String username;
    @NotBlank(message = "email is required")
    @Email(message = "Please Enter Valid Email")
    private String email;
    @NotBlank(message = "password is required")
    @Size(min = 8,message = "Password must be of 8 characters")
    private String password;
}
