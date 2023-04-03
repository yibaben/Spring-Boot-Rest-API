package com.yibaben.SpringBootRestAPI.services;

import com.yibaben.SpringBootRestAPI.dto.UserDto;
import com.yibaben.SpringBootRestAPI.entity.User;
import com.yibaben.SpringBootRestAPI.mapper.UserMapper;
import com.yibaben.SpringBootRestAPI.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;
    @Override
    public UserDto register(UserDto userDto) {
        // Convert UserDto to User JPA Entity
        User newUser = UserMapper.mapToUser(userDto);
        User savedUser = userRepository.save(newUser);

        // Convert User JPA Entity to UserDto
        UserDto savedUserDto = UserMapper.mapToUserDto(savedUser);
        return savedUserDto;
    }

    @Override
    public UserDto getUserById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        User user = optionalUser.get();
        return UserMapper.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        // convert List of User JPA Entity into List of UserDto
        List<User> users = userRepository.findAll();
        return users.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto user) {
        User existingUser = userRepository.findById(user.getId()).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        User updatedUser = userRepository.save(existingUser);
        return UserMapper.mapToUserDto(updatedUser);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
