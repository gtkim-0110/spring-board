package com.example.demo.service.impl;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Override
    public String test() {
        return userMapper.testConnection();
    }

    @Override
    public List<User> getAll() {
        return userMapper.findAll();
    }

    public void createUser(User user) {
        userMapper.createUser(user);
    }
}
