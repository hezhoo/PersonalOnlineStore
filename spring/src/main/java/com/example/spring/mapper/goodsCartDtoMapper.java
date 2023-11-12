package com.example.spring.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.spring.dto.goodsCartDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 25622
 */
@Mapper
public interface goodsCartDtoMapper extends BaseMapper<goodsCartDto> {

    @Select("SELECT g.goods_id, g.goods_name, g.goods_price, c.goods_count " +
            "FROM goods g " +
            "INNER JOIN cart c ON g.goods_id = c.goods_id " +
            "WHERE c.user_id = #{userId}")
    public List<goodsCartDto> getGoodsCart(int userId);

    @Select("SELECT sum(c.goods_count * g.goods_price) FROM goods g " +
            "INNER JOIN cart c ON g.goods_id = c.goods_id " +
            "WHERE c.user_id = #{userId}")
    public int getMoney (int userId);

}
