package com.example.service.service;

import com.example.service.entity.User;

import java.util.List;

public interface UserService {

    User findUserById(Long userId);

    User updateUser(User user);

    void addUser(User user);

    List<User> findUser();

    void delUser(Long userId);
}
