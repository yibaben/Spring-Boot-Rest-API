package com.yibaben.SpringBootRestAPI.services;

import com.yibaben.SpringBootRestAPI.dto.UserDto;
import com.yibaben.SpringBootRestAPI.entity.User;

import java.util.List;

public interface UserService {

    UserDto register(UserDto userDto);

    UserDto getUserById(Long userId);

    List<UserDto> getAllUsers();

    UserDto updateUser(UserDto user);

    void deleteUser(Long userId);

}
