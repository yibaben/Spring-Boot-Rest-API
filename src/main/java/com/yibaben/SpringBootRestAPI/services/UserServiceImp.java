package com.yibaben.SpringBootRestAPI.services;

import com.yibaben.SpringBootRestAPI.entity.User;
import com.yibaben.SpringBootRestAPI.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;
    @Override
    public User register(User user) {
        return userRepository.save(user);
    }
}
