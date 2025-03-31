package com.sachinsk.user_ms.service;

import com.sachinsk.user_ms.dto.UserDTO;
import com.sachinsk.user_ms.entity.User;
import com.sachinsk.user_ms.mapper.UserMapper;
import com.sachinsk.user_ms.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public UserDTO addUserToDB(UserDTO userDTO) {

        //mapping DTO to entity to save to DB : since we save entity to DB and Not the DTO
        User savedUser = userRepo.save(UserMapper.INSTANCE.mapUserDTOToUser(userDTO));

        //mapping entity back to DTO since we are returning the DTO to enduser and not the real entity
        return UserMapper.INSTANCE.mapUserToUserDTO(savedUser);
    }

    public UserDTO getUserById(Integer userId) {

        User searchedUser = userRepo.findById(userId).orElse(null);

        return UserMapper.INSTANCE.mapUserToUserDTO(searchedUser);
    }
}
