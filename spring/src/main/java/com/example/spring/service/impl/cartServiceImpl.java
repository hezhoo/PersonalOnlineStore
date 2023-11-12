package com.example.spring.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.spring.entity.cart;
import com.example.spring.mapper.cartMapper;
import com.example.spring.service.cartService;
import org.springframework.stereotype.Service;

@Service
public class cartServiceImpl extends ServiceImpl<cartMapper, cart> implements cartService {
}
