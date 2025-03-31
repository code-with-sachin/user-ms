package com.sachinsk.user_ms.service;

import com.sachinsk.user_ms.dto.UserDTO;

public interface UserService {

    public UserDTO addUserToDB(UserDTO userDTO);

    public UserDTO getUserById(Integer userId);
}
