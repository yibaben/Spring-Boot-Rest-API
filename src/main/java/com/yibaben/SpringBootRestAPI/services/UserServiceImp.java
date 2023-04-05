package com.yibaben.SpringBootRestAPI.services;

import com.yibaben.SpringBootRestAPI.dto.UserDto;
import com.yibaben.SpringBootRestAPI.entity.User;
import com.yibaben.SpringBootRestAPI.exception.UserNotFoundException;
import com.yibaben.SpringBootRestAPI.mapper.AutoUserMapper;
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
        // Convert UserDto to User JPA Entity Using UserMapper
        // User newUser = UserMapper.mapToUser(userDto);

        // Convert UserDto to User JPA Entity Using ModelMapper
        // User newUser = modelMapper.map(userDto, User.class);

        // Convert UserDto to User JPA Entity Using MapStruct
        User newUser = AutoUserMapper.MAPPER.mapToUser(userDto);
        User savedUser = userRepository.save(newUser);

        // Convert User JPA Entity to UserDto Using UserMapper
        // UserDto savedUserDto = UserMapper.mapToUserDto(savedUser);

        // Convert User JPA Entity to UserDto Using ModelMapper
        // UserDto savedUserDto = modelMapper.map(savedUser, UserDto.class);

        // Convert User JPA Entity to UserDto Using MapStruct
        UserDto savedUserDto = AutoUserMapper.MAPPER.mapToUserDto(savedUser);
        return savedUserDto;
    }

    @Override
    public UserDto getUserById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                ()-> new UserNotFoundException("User", "Id", userId));
//        UserMapper
//        return UserMapper.mapToUserDto(user);

//        ModelMapper
//        return modelMapper.map(user, UserDto.class);

//        MapStruct
        return AutoUserMapper.MAPPER.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        // convert List of User JPA Entity into List of UserDto Using UserMapper
        // return users.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());

        // convert List of User JPA Entity into List of UserDto Using ModelMapper
        // return users.stream().map((allUsers -> modelMapper.map(allUsers, UserDto.class))).collect(Collectors.toList());

        // convert List of User JPA Entity into List of UserDto Using MapStruct
        return users.stream().map((allUsers -> AutoUserMapper.MAPPER.mapToUserDto(allUsers))).collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto user) {
        User existingUser = userRepository.findById(user.getId()).orElseThrow(
                ()-> new UserNotFoundException("User", "Id", user.getId()));
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        User updatedUser = userRepository.save(existingUser);
        // UserMapper
        // return UserMapper.mapToUserDto(updatedUser);

        // ModelMapper
        // return modelMapper.map(updatedUser, UserDto.class);

        // MapStruct
        return AutoUserMapper.MAPPER.mapToUserDto(updatedUser);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.findById(userId).orElseThrow(()-> new UserNotFoundException("User", "Id", userId));
        userRepository.deleteById(userId);
    }
}
