package com.example.spring.dto;

import com.example.spring.entity.cart;
import com.example.spring.entity.goods;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
@Data
public class goodsCartDto {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    int userId;

    int goodsId;

    String goodsName;

    float goodsPrice;

    int goodsCount;

}
