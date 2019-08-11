package com.tobeng.example.controller;

import com.tobeng.example.dto.UserDTO;
import com.tobeng.example.entity.User;
import com.tobeng.example.service.UserService;
import groovy.util.logging.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController("user")
@Slf4j
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @PostMapping
    public String saveUser(@RequestBody @Valid UserDTO userDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            bindingResult.getAllErrors().forEach(objectError -> {
                sb.append(objectError.getDefaultMessage() + ";\n");
            });
            return sb.toString();
        }
        return userService.saveUser(userDTO);
    }

}
