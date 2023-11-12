package com.example.spring.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.example.spring.common.GlobalVariables;
import com.example.spring.common.R;
import com.example.spring.entity.goods;
import com.example.spring.entity.user;
import com.example.spring.service.goodsService;
import com.example.spring.service.userService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/goods")
@Slf4j
public class goodsController {
    @Autowired
    private goodsService goodsService;

    @Autowired
    private userService userService;

    @PostMapping("/all")
    public R<List<goods>> all(){
        log.info("查看所有商品");
        LambdaQueryWrapper<user> queryWrapperUser = new LambdaQueryWrapper<>();
        queryWrapperUser.eq(user::getUserPhone, GlobalVariables.getInstance().getGlobalPhone());
        user user = userService.getOne(queryWrapperUser);
        if(user!=null){
            GlobalVariables.setGlobalId(user.getUserId());
        }

        LambdaQueryWrapper<goods> queryWrapper =new LambdaQueryWrapper<>();
        List<goods> goodsList =goodsService.list(queryWrapper);
        return R.success(goodsList);
    }
    @PostMapping("/save")
    public R<goods> save(@RequestBody goods goods){
        log.info("添加商品:{}",goods.toString());
        goodsService.save(goods);
        return R.success(goods);
    }
    @PostMapping("/delete")
    public R<goods> delete (@RequestParam int goodsId){
        log.info("删除商品{}",goodsId);
        LambdaQueryWrapper<goods> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(goods::getGoodsId,goodsId);
        goods goods = goodsService.getOne(lambdaQueryWrapper);
        goodsService.remove(lambdaQueryWrapper);
        return R.success(goods);
    }

    @PostMapping("/change")
    public R<goods> change(@RequestBody goods goodsOne){
        log.info("修改商品信息:{}",goodsOne.toString());
        LambdaUpdateWrapper<goods> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.eq(goods::getGoodsId, goodsOne.getGoodsId())
                .set(goods::getGoodsName, goodsOne.getGoodsName())
                .set(goods::getGoodsPrice, goodsOne.getGoodsPrice());
        boolean success = goodsService.update(lambdaUpdateWrapper);
        if (success) {
            return R.success(goodsOne);
        } else {
            return R.error("商品信息更新失败");
        }
    }
}
