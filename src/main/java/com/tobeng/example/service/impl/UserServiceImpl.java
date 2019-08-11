package com.tobeng.example.service.impl;

import com.tobeng.example.dao.UserDao;
import com.tobeng.example.dto.UserDTO;
import com.tobeng.example.entity.User;
import com.tobeng.example.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public List<User> getAllUser(){
        return userDao.findAll();
    }

    @Override
    public String saveUser(UserDTO userDTO) {
        User user = new User();
        user.setCity(userDTO.getCity());
        user.setName(userDTO.getName());
        user.setId(userDTO.getId());
        return userDao.save(user).toString();
    }

}
