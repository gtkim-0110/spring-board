package com.example.demo.service;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    String test();
    List<User> getAll(@Param("page") int page, @Param("size") int size);
    void createUser(User user);
}
