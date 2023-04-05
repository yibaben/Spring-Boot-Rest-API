package com.yibaben.SpringBootRestAPI.mapper;

import com.yibaben.SpringBootRestAPI.dto.UserDto;
import com.yibaben.SpringBootRestAPI.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoUserMapper {

    // MapStruct will provide implementation of this interface at compilation time
    AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);

    // In the case of diff fields names in the Entity class and Dto class
    // We can use @Mapping annotation from MapStruct to map the fields.
//    @Mapping(source = "email", target = "emailAddress")
     UserDto mapToUserDto(User user);

     User mapToUser(UserDto userDto);
}
