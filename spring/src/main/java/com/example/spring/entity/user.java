package com.example.spring.entity;

import lombok.Data;
import org.springframework.context.annotation.Bean;

import java.io.Serializable;

@Data
public class user implements Serializable {


    int userId;

    String userPhone;
}
