package com.example.spring.repository;

import com.example.spring.dto.goodsCartDto;
import org.springframework.data.repository.CrudRepository;

public interface goodsCartDtoRepository extends CrudRepository<goodsCartDto,Integer> {
}
