package com.example.spring.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.spring.common.GlobalVariables;
import com.example.spring.common.R;
import com.example.spring.dto.goodsCartDto;
import com.example.spring.entity.cart;
import com.example.spring.service.cartService;
import com.example.spring.service.goodsCartDtoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@Controller
@Slf4j
@RequestMapping("/cart")
public class cartController {

    @Autowired
    private goodsCartDtoService goodsCartDtoService;

    @Autowired
    private cartService cartService;

    @PostMapping("/all")
    public R<List<goodsCartDto>> all() {
        log.info("查看购物车");
        //List<goodsCartDto> goodsCartList = goodsCartDtoService.getAllCart(GlobalVariables.getInstance().getGlobalId()) ;
        return R.success(goodsCartDtoService.getAllCart(GlobalVariables.getInstance().getGlobalId()));
    }

    @PostMapping("/add")
    public R<cart> add(@RequestParam int goodsId){
        log.info("添加商品{}到购物车",goodsId);
        int userId = GlobalVariables.getInstance().getGlobalId();
        LambdaQueryWrapper<cart> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(cart::getUserId,userId);
        lambdaQueryWrapper.eq(cart::getGoodsId,goodsId);
        cart cart = cartService.getOne(lambdaQueryWrapper);
        if(cart==null){
            cart cart1 = new cart();
            cart1.setUserId(userId);
            cart1.setGoodsId(goodsId);
            cart1.setGoodsCount(1);
            cartService.save(cart1);
            return R.success(cart1);
        }
        else {
            cart.setGoodsCount(cart.getGoodsCount()+1);
            cartService.update(cart,lambdaQueryWrapper);
            return R.success(cart);
        }
    }

    @PostMapping("/delete")
    public R<cart> delete (@RequestParam int goodsId){
        log.info("从购物车删除商品{}",goodsId);
        int userId = GlobalVariables.getInstance().getGlobalId();
        LambdaQueryWrapper<cart> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(cart::getUserId,userId);
        lambdaQueryWrapper.eq(cart::getGoodsId,goodsId);
        cart cart = cartService.getOne(lambdaQueryWrapper);
        if(cart.getGoodsCount()==1){
            cartService.remove(lambdaQueryWrapper);
        }
        else {
            cart.setGoodsCount(cart.getGoodsCount()-1);
            cartService.update(cart,lambdaQueryWrapper);
        }
        return R.success(cart);
    }

    //清空购物车
    @PostMapping("/clean")
    public R<String>clean(){
        LambdaQueryWrapper<cart> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(cart::getUserId,GlobalVariables.getInstance().getGlobalId());
        cartService.remove(queryWrapper);
        return R.success("清空购物车成功");
    }

    @PostMapping("/pay")
    public R<Integer> pay(){
        return R.success(goodsCartDtoService.getMoney(GlobalVariables.getInstance().getGlobalId()));
    }

}
