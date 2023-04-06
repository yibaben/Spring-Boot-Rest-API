package com.yibaben.SpringBootRestAPI.controller;

import com.yibaben.SpringBootRestAPI.dto.UserDto;
import com.yibaben.SpringBootRestAPI.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(
        name = "CRUD RestFul APIs for UserController",
        description = "CRUD-REST APIs for Register-User, Update-User, Get-User, Get-All-Users, Delete User"
)
@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private final UserService userService;

    @Operation(
            summary = "Create/Register User Rest Api",
            description = "Create a New User and Stored in the Data-base"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status Code 201 CREATED"
    )
    @PostMapping("register")
    public ResponseEntity<UserDto> registerUser(@Valid @RequestBody UserDto userDto) {
        UserDto savedUser = userService.register(userDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }


    @Operation(
            summary = "Get User By Id Rest Api",
            description = "Getting User By Id from the DataBase"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status Code 200 SUCCESS"
    )
    @GetMapping("getUser/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId) {
        UserDto retrievedUser = userService.getUserById(userId);
        return new ResponseEntity<>(retrievedUser, HttpStatus.OK);
    }


    @Operation(
            summary = "Get All Users Rest Api",
            description = "Getting All Users from the DataBase"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status Code 200 SUCCESS"
    )
    @GetMapping("getAllUsers")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> allUsers = userService.getAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }


    @Operation(
            summary = "Update User Profile Rest Api",
            description = "Update a Particular User Profile in the DataBase"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status Code 200 SUCCESS"
    )
    @PutMapping("updateUser/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userId,
                                           @RequestBody @Valid UserDto user) {
        user.setId(userId);
        UserDto updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }


    @Operation(
            summary = "Delete User Rest Api",
            description = "Delete a Particular User Profile from the DataBase"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status Code 200 SUCCESS"
    )
    @DeleteMapping("deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>("User Deleted Successfully!!!", HttpStatus.OK);
    }
}
