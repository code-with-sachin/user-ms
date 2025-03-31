package com.sachinsk.user_ms.controller;

import com.sachinsk.user_ms.dto.UserDTO;
import com.sachinsk.user_ms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO) {
        UserDTO userAdded = userService.addUserToDB(userDTO);
        return new ResponseEntity<>(userAdded, HttpStatus.CREATED);

    }

    @GetMapping("/fetchById/{userId}")
    public ResponseEntity<UserDTO> fetchUserById(@PathVariable Integer userId) {
        UserDTO userFound =userService.getUserById(userId);

        if (userFound != null){
            return new ResponseEntity<>(userFound, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }
}
