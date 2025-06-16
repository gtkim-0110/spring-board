package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    String test();
    List<User> getAll();
    void createUser(User user);
}
