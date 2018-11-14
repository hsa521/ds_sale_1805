package com.mr.mapper;

import com.mr.model.TMallShoppingCar;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by ${ShenTao} on 2018/11/8.
 */
public interface CartMapper {
    List<TMallShoppingCar> listCartByUserId(@Param("userId") Integer userId);

    void saveCart(TMallShoppingCar cart);

    void updateCartBySkuIdAndUserId(Map<String, Object> cartMap);

    void saveCartList(Map<String, Object> cartList);

    TMallShoppingCar findCartBySkuIdAndUserId(@Param("skuId")Integer skuId, @Param("userId")Integer userId);

    void updateCartShfxzBySkuIdAndUserId(Map<String, Object> map);
}
