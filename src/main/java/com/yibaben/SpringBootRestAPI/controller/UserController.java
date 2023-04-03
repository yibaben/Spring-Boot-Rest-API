package com.yibaben.SpringBootRestAPI.controller;

import com.yibaben.SpringBootRestAPI.entity.User;
import com.yibaben.SpringBootRestAPI.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private final UserService userService;

    @PostMapping("register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User savedUser = userService.register(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("getUser/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long userId) {
        User retrievedUser = userService.getUserById(userId);
        return new ResponseEntity<>(retrievedUser, HttpStatus.OK);
    }

    @GetMapping("getAllUsers")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> allUsers = userService.getAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }
}
