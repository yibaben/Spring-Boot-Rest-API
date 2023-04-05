package com.yibaben.SpringBootRestAPI.controller;

import com.yibaben.SpringBootRestAPI.dto.UserDto;
import com.yibaben.SpringBootRestAPI.entity.User;
import com.yibaben.SpringBootRestAPI.exception.ErrorDetails;
import com.yibaben.SpringBootRestAPI.exception.UserNotFoundException;
import com.yibaben.SpringBootRestAPI.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private final UserService userService;

    @PostMapping("register")
    public ResponseEntity<UserDto> registerUser(@RequestBody UserDto userDto) {
        UserDto savedUser = userService.register(userDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("getUser/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId) {
        UserDto retrievedUser = userService.getUserById(userId);
        return new ResponseEntity<>(retrievedUser, HttpStatus.OK);
    }

    @GetMapping("getAllUsers")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> allUsers = userService.getAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @PutMapping("updateUser/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userId,
                                           @RequestBody UserDto user) {
        user.setId(userId);
        UserDto updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>("User Deleted Successfully!!!", HttpStatus.OK);
    }
    // Method to Handle Specific Exception Related to a Controller
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDetails> exceptionHandler(UserNotFoundException exception,
                                                         WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false),
                "USER_NOT_FOUND"
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
}
