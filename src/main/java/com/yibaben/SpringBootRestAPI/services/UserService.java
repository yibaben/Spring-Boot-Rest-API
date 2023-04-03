package com.yibaben.SpringBootRestAPI.services;

import com.yibaben.SpringBootRestAPI.entity.User;

import java.util.List;

public interface UserService {

    public User register(User user);

    public User getUserById(Long userId);

    public List<User> getAllUsers();

}
