package com.yibaben.SpringBootRestAPI.services;

import com.yibaben.SpringBootRestAPI.entity.User;

public interface UserService {

    public User register(User user);

    public User getUserById(Long userId);

}
