package com.example.spring.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.spring.entity.goods;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface goodsMapper extends BaseMapper<goods> {
}
