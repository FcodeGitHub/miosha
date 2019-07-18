package com.xcy.seckill.controller;

import com.xcy.seckill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public boolean login(String username,String password){
       int count =  userService.userLogin(username,password);
       return count > 0 ? true : false;
    }
}
