package com.example.spring.mapper;

import com.example.spring.entity.user;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface userMapper extends BaseMapper<user>{
}
