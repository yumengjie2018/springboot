package com.example.service.service.impl;


import com.alibaba.fastjson.JSON;
import com.example.service.entity.User;
import com.example.service.mapper.UserMapper;
import com.example.service.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @Author: romantic_ke@163.com
 * @Description:
 * @Date: 2019/9/7 9:54
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper mapper;

    @Override
    public User findUserById(Long userId) {
        log.info("findUserById入参=" + userId);
        Optional<User> user = mapper.findById(userId);
        return user.get();
    }

    @Override
    @Transactional
    public User updateUser(User user) {
        log.info("updateUser入参=" + JSON.toJSONString(user));
        User userById = findUserById(user.getUserId());
        if (Objects.isNull(userById)) {
            System.out.println("数据错误");
        }
        User save = mapper.save(user);
        return save;
    }

    @Override
    @Transactional
    public void addUser(User user) {
        log.info("addUser入参=" + JSON.toJSONString(user));
        mapper.save(user);
    }

    @Override
    public List<User> findUser() {
        log.info("findUser入参=");
        List<User> users = mapper.findAll();
        return users;
    }

    @Override
    public void delUser(Long userId) {
        log.info("delUser入参=" + userId);
        mapper.deleteById(userId);
    }

}
