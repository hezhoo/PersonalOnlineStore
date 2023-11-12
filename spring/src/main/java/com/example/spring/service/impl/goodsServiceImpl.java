package com.example.spring.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.spring.entity.goods;
import com.example.spring.mapper.goodsMapper;
import com.example.spring.service.goodsService;
import org.springframework.stereotype.Service;

/**
 * @author 25622
 */
@Service
public class goodsServiceImpl extends ServiceImpl<goodsMapper, goods> implements goodsService {
}
