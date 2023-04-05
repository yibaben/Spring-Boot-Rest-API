package com.yibaben.SpringBootRestAPI.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;
    @NotEmpty(message = "User firstName should not be null or empty")
    private String firstName;
    @NotEmpty(message = "User lastName should not be null or empty")
    private String lastName;
    @NotEmpty(message = "User email should not be null or empty")
    @Email(message = "User email address must be a valid email")
    private String email;
}
