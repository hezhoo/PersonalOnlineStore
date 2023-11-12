package com.example.spring.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.spring.entity.cart;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface cartMapper extends BaseMapper<cart> {
}
