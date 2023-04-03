package com.yibaben.SpringBootRestAPI.services;

import com.yibaben.SpringBootRestAPI.entity.User;

import java.util.List;

public interface UserService {

    User register(User user);

    User getUserById(Long userId);

    List<User> getAllUsers();

    User updateUser(User user);

    void deleteUser(Long userId);

}
