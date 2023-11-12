package com.example.spring.service;

import com.example.spring.dto.goodsCartDto;
import com.example.spring.mapper.goodsCartDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class goodsCartDtoService {

    @Autowired
    private com.example.spring.mapper.goodsCartDtoMapper goodsCartDtoMapper;

    public List<goodsCartDto> getAllCart(int userId) {
        return goodsCartDtoMapper.getGoodsCart(userId);
    }

    public int getMoney(int userId) {
        return goodsCartDtoMapper.getMoney(userId);
    }
}
