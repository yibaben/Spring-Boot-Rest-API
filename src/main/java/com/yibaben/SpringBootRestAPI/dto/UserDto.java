package com.yibaben.SpringBootRestAPI.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "UserDto Model Information")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;
    @Schema(description = "User First Name")
    @NotEmpty(message = "User firstName should not be null or empty")
    private String firstName;
    @Schema(description = "User Last Name")
    @NotEmpty(message = "User lastName should not be null or empty")
    private String lastName;
    @Schema(description = "User Email Address")
    @NotEmpty(message = "User email should not be null or empty")
    @Email(message = "User email address must be a valid email")
    private String email;
}
