package com.example.spring.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class goods implements Serializable {
    int goodsId;

    String goodsName;

    float goodsPrice;

}
