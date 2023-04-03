package com.yibaben.SpringBootRestAPI.services;

import com.yibaben.SpringBootRestAPI.dto.UserDto;
import com.yibaben.SpringBootRestAPI.entity.User;

import java.util.List;

public interface UserService {

    UserDto register(UserDto userDto);

    User getUserById(Long userId);

    List<User> getAllUsers();

    User updateUser(User user);

    void deleteUser(Long userId);

}
