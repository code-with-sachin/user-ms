package com.sachinsk.user_ms.mapper;

import com.sachinsk.user_ms.dto.UserDTO;
import com.sachinsk.user_ms.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    //creating instance
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    //We would need two methods: 1) To convert DTO to entity ; 2) To convert entity to DTO

    //This will return User : it will map DTO to user

    User mapUserDTOToUser(UserDTO userDTO);


    //This will return UserDTO : it will map User to user DTO

    UserDTO mapUserToUserDTO(User user);
}
