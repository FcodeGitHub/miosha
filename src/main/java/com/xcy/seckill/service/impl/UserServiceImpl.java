package com.xcy.seckill.service.impl;

import com.xcy.seckill.mapper.UserMapper;
import com.xcy.seckill.service.UserService;
import com.xcy.seckill.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Override
    public int userLogin(String userName, String password) {
        Map<String,String> map = new HashMap<String,String>();
        map.put("phoneNum",userName);
        map.put("password", MD5Utils.getMD5(password));
        return userMapper.login(map);

    }
}
