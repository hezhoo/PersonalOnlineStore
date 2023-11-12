package com.example.spring.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class cart implements Serializable {
    int userId;

    int goodsId;

    int goodsCount;

}
