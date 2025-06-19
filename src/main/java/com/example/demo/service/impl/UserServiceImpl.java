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
    public List<User> getAll(int page, int size) {

        if( page < 1 || size < 1 ) {
            throw new IllegalArgumentException("page or size must be greater than 0");
        }

        int offset = ( page - 1 ) * size;
        return userMapper.findAll(size, offset);
    }

    public void createUser(User user) {
        userMapper.createUser(user);
    }
}
