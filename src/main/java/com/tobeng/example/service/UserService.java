package com.tobeng.example.service;

import com.tobeng.example.dto.UserDTO;
import com.tobeng.example.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUser();

    String saveUser(UserDTO userDTO);

}
