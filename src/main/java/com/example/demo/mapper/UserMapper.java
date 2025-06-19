package com.example.demo.mapper;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    String testConnection();
    List<User> findAll(int size, int offset);
    void createUser(User user);
}
