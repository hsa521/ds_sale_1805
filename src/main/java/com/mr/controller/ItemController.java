package com.mr.controller;


import com.mr.model.TMallSku;
import com.mr.model.TMallSkuItemVO;
import com.mr.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by ${ShenTao} on 2018/11/7.
 */
@Controller
public class ItemController {

    @Autowired
    private SkuService skuService;

    /**
     * 跳转商品详情页面
     * @param skuId
     * @param spuId
     * @param map
     * @return
     */
    @RequestMapping("toItemPage")
    public String toItemPage(Integer skuId, Integer spuId, ModelMap map){
        //sku的数据
        TMallSkuItemVO itemvo= skuService.listItemBySkuId(skuId);

        //spuid查询到的sku集合
        List<TMallSku> skuList = skuService.listSkuBySpuId(spuId);

        map.put("itemvo",itemvo);
        map.put("skuList",skuList);

        return "item";
    }

}
