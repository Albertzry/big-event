package org.example.controller;

import org.example.pojo.User;
import org.example.service.UserService;
import org.example.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(String username, String password) {
        //查询用户
        User u = userService.findByUsername(username);
        if (u == null) {
            //用户不存在，可以注册
            userService.register(username, password);
            return Result.success();
        } else {
            //用户存在，不可以注册
            return Result.error("用户名已存在");
        }
    }
}