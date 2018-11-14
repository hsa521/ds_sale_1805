package com.mr.controller;

import com.mr.model.*;
import com.mr.service.OrderService;
import com.mr.util.MyDateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by ${ShenTao} on 2018/11/12.
 */
@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 跳转核对页面
     * @return
     */
    @RequestMapping("toCheckOrder")
    public String toCheckOrder(HttpSession session, ModelMap map){
        TMallUserAccount user = (TMallUserAccount)session.getAttribute("user");
        if (user == null){//没有登录
            return "redirect:toLoginPage.do?loginSuccessUrl=toCheckOrder";
        }else {
            //通过当前用户查询地址
            List<TMallAddress> addressList = orderService.listAddressByYhId(user.getId());
            //获取到购物车中被选中的状态

            //从redis中获取当前用户的购物车数据
            List<TMallShoppingCar> cartList = (List<TMallShoppingCar>)redisTemplate.opsForValue().get("redisCartListUser"+user.getId());

            List<TMallShoppingCar>  checkOrderList = new ArrayList();

            for (int i = 0; i < cartList.size(); i++) {
                TMallShoppingCar cart = cartList.get(i);
                //如果被选中则添加在集合中
                if (cart.getShfxz().equals("1")){//被选中
                    checkOrderList.add(cart);
                }
            }

            map.put("addressList",addressList);
            map.put("checkOrderList",checkOrderList);
            map.put("sum",CartController.getSum(cartList));
            //去核对页面
            return "checkOrder";
        }
    }

    /**
     * 保存订单
     * @return
     */
    @RequestMapping("saveOrder")
    public String saveOrder(TMallAddress address,HttpSession session){
        //获取用户
        TMallUserAccount user = (TMallUserAccount)session.getAttribute("user");
        //通过

        //从redis中获取当前用户的购物车数据
        List<TMallShoppingCar> cartList = (List<TMallShoppingCar>)redisTemplate.opsForValue().get("redisCartListUser"+user.getId());

        //实体类：一个订单、多个物流信息、每个订单有多个物流详情
        TMallOrderVO orderVO = new TMallOrderVO();
        orderVO.setJdh(1);
        orderVO.setZje(CartController.getSum(cartList).doubleValue());
        orderVO.setYhId(user.getId());
        orderVO.setDzhId(address.getId());
        orderVO.setDzhMch(address.getDzMch());
        orderVO.setShhr(address.getShjr());

        //物流信息存放
        List<TMallFlowVO> flowList = new ArrayList();
        //存放库存地址的集合
        Set<String> flowSet = new HashSet<>();
        //拆单：根据不同的库存地址来拆分
        for (int i = 0; i < cartList.size(); i++) {
            String kcdz = cartList.get(i).getKcdz();
            flowSet.add(kcdz);
        }
        Iterator<String> flowIterator = flowSet.iterator();
        while (flowIterator.hasNext()){
            String nextKcdz = flowIterator.next();
            TMallFlowVO flowVO = new TMallFlowVO();
            flowVO.setPsfsh("天天快递");
            flowVO.setPsshj(MyDateUtil.getMyDateD(new Date(), 1));
            flowVO.setPsfsh("配送描述：不管在那，我们会第一时间将货物送达");
            flowVO.setYhId(user.getId());
            //订单详情集合
            List<TMallOrderInfo> infoList = new ArrayList<>();
            for (int i = 0; i < cartList.size(); i++) {
                TMallOrderInfo info = new TMallOrderInfo();
                TMallShoppingCar car = cartList.get(i);
                if (car.getKcdz().equals(nextKcdz)){
                    info.setSkuJg(car.getSkuJg());
                    info.setSkuShl(car.getTjshl());
                    info.setSkuKcdz(car.getKcdz());
                    info.setGwchId(car.getId());
                    info.setSkuId(car.getSkuId());
                    info.setSkuMch(car.getSkuMch());
                    info.setShpTp(car.getShpTp());

                    infoList.add(info);
                }

            }

            //在物流中添加info信息
            flowVO.setInfoList(infoList);
            //将每一个符合地址的数据放在物流集合中
            flowList.add(flowVO);
        }

        orderVO.setFlowList(flowList);

        orderService.saveOrder(orderVO);
        //更新redis
        redisTemplate.delete("redisCartListUser"+user.getId());
        //跳转到支付页面
        return "redirect:pay.do";
    }

    @RequestMapping("pay")
    public String pay(){

        return "pay";
    }

    public static void main(String[] args) {

        new Date();
    }


}
