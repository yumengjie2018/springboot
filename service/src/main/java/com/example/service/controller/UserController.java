package com.example.service.controller;


import com.example.service.entity.User;
import com.example.service.entity.response.ResponseMessage;
import com.example.service.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/app/user")
@RestController
@Api(tags = "redis缓存测试")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/findUser")
    @ApiOperation(value = "id查询")
    public ResponseMessage<User> findUser(Long userId) {
        User user = userService.findUserById(userId);
        return ResponseMessage.Success2(user);
    }

    @GetMapping("/findAll")
    @ApiOperation(value = "查看全部")
    public ResponseMessage<List<User>> findAll() {
        List<User> user = userService.findUser();
        return ResponseMessage.Success2(user);
    }

    @PostMapping("/addUser")
    @ApiOperation(value = "添加用户")
    public ResponseMessage addUser(@RequestBody User user) {
         userService.addUser(user);
        return ResponseMessage.Success();
    }

    @PostMapping("/update")
    @ApiOperation(value = "更新用户")
    public ResponseMessage<User> updateUser(@RequestBody User user) {
        User saveUser = userService.updateUser(user);
        return ResponseMessage.Success2(saveUser);
    }

    @PostMapping("/del")
    @ApiOperation(value = "删除用户")
    public ResponseMessage<String> delUser( Long userId) {
        this.userService.delUser(userId);
        return ResponseMessage.Success2("DEL-OK");
    }

}
