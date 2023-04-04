package com.yibaben.SpringBootRestAPI.services;

import com.yibaben.SpringBootRestAPI.dto.UserDto;
import com.yibaben.SpringBootRestAPI.entity.User;
import com.yibaben.SpringBootRestAPI.mapper.UserMapper;
import com.yibaben.SpringBootRestAPI.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    @Override
    public UserDto register(UserDto userDto) {
        // Convert UserDto to User JPA Entity
//        User newUser = UserMapper.mapToUser(userDto);
        User newUser = modelMapper.map(userDto, User.class);
        User savedUser = userRepository.save(newUser);

        // Convert User JPA Entity to UserDto
//        UserDto savedUserDto = UserMapper.mapToUserDto(savedUser);
        UserDto savedUserDto = modelMapper.map(savedUser, UserDto.class);
        return savedUserDto;
    }

    @Override
    public UserDto getUserById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        User user = optionalUser.get();
//        return UserMapper.mapToUserDto(user);
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public List<UserDto> getAllUsers() {
        // convert List of User JPA Entity into List of UserDto
        List<User> users = userRepository.findAll();
//        return users.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
        return users.stream().map((allUsers -> modelMapper.map(allUsers, UserDto.class))).collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto user) {
        User existingUser = userRepository.findById(user.getId()).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        User updatedUser = userRepository.save(existingUser);
//        return UserMapper.mapToUserDto(updatedUser);
        return modelMapper.map(updatedUser, UserDto.class);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
