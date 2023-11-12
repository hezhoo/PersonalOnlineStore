package com.example.spring.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.spring.entity.user;
import com.example.spring.mapper.userMapper;
import com.example.spring.service.userService;
import org.springframework.stereotype.Service;

@Service
public class userServiceImpl extends ServiceImpl<userMapper, user>implements userService {
}
