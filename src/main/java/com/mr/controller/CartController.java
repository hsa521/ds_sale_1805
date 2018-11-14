package com.mr.controller;

import com.mr.model.TMallShoppingCar;
import com.mr.model.TMallUserAccount;
import com.mr.service.CartService;
import com.mr.util.MyCookieUtils;
import com.mr.util.MyJsonUtil;
import com.sun.org.apache.regexp.internal.REUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ${ShenTao} on 2018/11/7.
 */
@Controller
public class CartController {

    @Autowired
    private CartService cartService;
    @Autowired
    private RedisTemplate redisTemplate;

    //计算价格、获取合计值
    public static Double geiHj(TMallShoppingCar cart){
        BigDecimal jg = new BigDecimal(cart.getSkuJg() + "");
        BigDecimal thShl = new BigDecimal(cart.getTjshl());
        double hj = thShl.multiply(jg).doubleValue();
        return hj;
    }

    /**
     * 保存购物车
     * cookie : cookieCartList
     * @cookieValue("key") 该注解的作用:从cookie对象中获取名为key的cookie值
     * @param cart
     * @param session
     * @return
     */
    @RequestMapping("saveCart")
    public String saveCart(TMallShoppingCar cart, HttpSession session,
                           @CookieValue(value = "cookieCartList", required = false) String cookieCartList,
                           HttpServletRequest request, HttpServletResponse response,ModelMap map){

        /*BigDecimal jg = new BigDecimal(cart.getSkuJg() + "");
        BigDecimal shl = new BigDecimal(cart.getTjshl());*/
        cart.setHj(geiHj(cart));


        //定义购物车集合
        List<TMallShoppingCar> cartList = new ArrayList<TMallShoppingCar>();

        //判断是否登录
        TMallUserAccount user = (TMallUserAccount)session.getAttribute("user");
        if (user==null){//未登录
            if (StringUtils.isBlank(cookieCartList)){//为空   数据直接添加在cookie中
                //给购物车集合添加数据
                cartList.add(cart);
                //存放在cookie中
            }else{//有数据则需要判断更新
                //判断是否存在
                cartList = MyJsonUtil.jsonToList(cookieCartList, TMallShoppingCar.class);
                boolean flag = false;
                for (int i = 0; i < cartList.size(); i++) {
                    if (cartList.get(i).getSkuId() == cart.getSkuId()){//表示存在
                        flag = true;
                    }
                }
                if (flag){//存在
                    //更新 拿到购物车中的数据  更新  循环
                    cartList = MyJsonUtil.jsonToList(cookieCartList, TMallShoppingCar.class);
                    for (int i = 0; i <cartList.size() ; i++) {
                        if (cartList.get(i).getSkuId()==cart.getSkuId()){//一样则修改数量
                            cartList.get(i).setTjshl(cartList.get(i).getTjshl() + cart.getTjshl());

                            /*BigDecimal jg = new BigDecimal(cartList.get(i).getSkuJg() + "");
                            BigDecimal shl = new BigDecimal(cartList.get(i).getTjshl());*/
                            //计算价格和数量
                            cartList.get(i).setHj(geiHj(cartList.get(i)));
                        }
                    }
                }else{//不存在
                    cartList.add(cart);
                }
            }
            //存放在cookie中
            MyCookieUtils.setCookie(request,response,"cookieCartList", MyJsonUtil.objectToJson(cartList),
                    12*60*60,true);
        }else{//登录

            //判断当前用户，数据库中是否有数据
            //获取数据
            cartList = cartService.listCartByUserId(user.getId());
            if (cartList != null && cartList.size() > 0){//有数据
                boolean flag = false;
                //循环遍历、如果存在
                for (int i = 0; i < cartList.size(); i++) {
                    if (cartList.get(i).getSkuId() == cart.getSkuId()){
                        flag = true;
                    }
                }

                if (flag){//存在
                    //更新数据
                    for (int i = 0; i < cartList.size(); i++) {
                        if (cartList.get(i).getSkuId() == cart.getSkuId()){
                            Map<String,Object> cartMap = new HashMap();
                            cartMap.put("skuId",cartList.get(i).getSkuId());
                            cartMap.put("userId",user.getId());
                            cartMap.put("tjshl",cartList.get(i).getTjshl() + cart.getTjshl());

                            /*BigDecimal jg = new BigDecimal(cartList.get(i).getSkuJg() + "");
                            BigDecimal shl = new BigDecimal(cartList.get(i).getTjshl());*/
                            //计算价格和数量
                            cartMap.put("hj",geiHj(cartList.get(i)));

                            cartService.updateCartBySkuIdAndUserId(cartMap);

                        }
                    }

                }else{
                    //添加数据
                    cart.setYhId(user.getId());
                    cartService.saveCart(cart);
                }
            }else{//没有
                //添加数据
                cart.setYhId(user.getId());
                cartService.saveCart(cart);
            }
            //更新 redis（清除redis中Cart的list，当前用户）
            redisTemplate.delete("redisCartListUser"+user.getId());
            //用户登录后、将数据保存在redis中
            //当前用户的key如何确定
            //redisTemplate.opsForValue().set("redisCartListUser"+user.getId(),cartList);


        }
        map.put("cart",cart);


        return "cart-success";
    }

    //查询mini购物车
    @RequestMapping("findMiniCart")
    public String findMiniCart(HttpSession session, ModelMap map,@CookieValue(value = "cookieCartList",required = false)
            String cookieCartList){

        List<TMallShoppingCar> cartList = new ArrayList<TMallShoppingCar>();
        //判断是否登录
        TMallUserAccount user = (TMallUserAccount)session.getAttribute("user");
        if (user==null){//未登录
            cartList = MyJsonUtil.jsonToList(cookieCartList,TMallShoppingCar.class);
        }else {//登录
            //从redis中获取数据
            cartList = (List<TMallShoppingCar>) redisTemplate.opsForValue().get("redisCartListUser" + user.getId());
            if (cartList == null || cartList.size() == 0){//没有数据
                //通过用户、查询数据库
                cartList = cartService.listCartByUserId(user.getId());
                redisTemplate.opsForValue().set("redisCartListUser"+user.getId(),cartList);
            }
        }
        Integer countNum = 0;
        for (int i = 0; i < cartList.size(); i++) {
            countNum += cartList.get(i).getTjshl();
        }

        map.put("cartList",cartList);
        map.put("countNum",countNum);
        map.put("hjSum",getSum(cartList));
        return "miniCartInner";
    }


    public static BigDecimal getSum(List<TMallShoppingCar> cartList){
        BigDecimal sum = new BigDecimal("0");

        for (int i = 0; i < cartList.size(); i++) {
            if (cartList.get(i).getShfxz().equals("1")){//如果选中则加
                sum = sum.add(new BigDecimal(cartList.get(i).getHj() + ""));
            }
        }
        return sum;
    }

    //去购物车
    @RequestMapping("toCartListPage")
    public String toCartListPage(HttpSession session, ModelMap map,
                                 @CookieValue(value = "cookieCartList",required = false) String cookieCartList){

        List<TMallShoppingCar> cartList = new ArrayList<>();
        //判断是否登录
        TMallUserAccount user = (TMallUserAccount)session.getAttribute("user");
        if(user == null){//未登录
            cartList = MyJsonUtil.jsonToList(cookieCartList, TMallShoppingCar.class);
        }else{//登录
            //从redis中获取数据
            cartList = (List<TMallShoppingCar>)redisTemplate.opsForValue().get("redisCartListUser" + user.getId());
            if(cartList == null || cartList.size() == 0){//没有数据
                //查询数据库、通过用户
                cartList = cartService.listCartByUserId(user.getId());
                redisTemplate.opsForValue().set("redisCartListUser"+user.getId(),cartList);
            }
        }
        /*Integer countNum = 0;
        for (int i = 0; i < cartList.size(); i++) {
            countNum += cartList.get(i).getTjshl();
        }*/
        map.put("cartList",cartList);
        //map.put("countNum",countNum);
        map.put("hjSum",getSum(cartList));
        return "cartList";
    }

    /**
     * 根据skuId修改对象的选中状态、并刷新合计
     * @param skuId
     * @param shfxz
     * @param map
     * @param cookieCartList
     * @return
     */
    @RequestMapping("changeShfxz")
    public String changeShfxz(HttpServletResponse response ,HttpServletRequest request,
                              int skuId , String shfxz , ModelMap map,HttpSession session,
                              @CookieValue(value = "cookieCartList",required = false) String cookieCartList){

        List<TMallShoppingCar> cartList = new ArrayList<>();
        //判断是否登录
        TMallUserAccount user = (TMallUserAccount)session.getAttribute("user");
        if(user != null){//登录
            //通过skuId 修改 cart
            //从reids中获取到数据
            cartList =  (List<TMallShoppingCar>)redisTemplate.opsForValue().get("redisCartListUser"+user.getId());

            //更新数据库
            for (int i = 0; i < cartList.size(); i++) {
                if(cartList.get(i).getSkuId() == skuId){
                    //修改数据库的状态
                    cartService.updateCartShfxzBySkuIdAndUserId(skuId,user.getId(),shfxz);
                    //修改
                    cartList.get(i).setShfxz(shfxz);
                }
            }
            //同步redis中
            redisTemplate.opsForValue().set("redisCartListUser"+user.getId(),cartList);

        }else{//未登录
            cartList = MyJsonUtil.jsonToList(cookieCartList,TMallShoppingCar.class);
            for (int i = 0; i < cartList.size(); i++) {
                //如果skuId一样的话，修改该对象的状态。
                if(cartList.get(i).getSkuId() == skuId){
                    cartList.get(i).setShfxz(shfxz);
                }
            }
            //更新cookie
            MyCookieUtils.setCookie(request,response,"cookieCartList",
                    MyJsonUtil.objectToJson(cartList),12*60*60,true);
        }

        map.put("cartList",cartList);
        map.put("hjSum",getSum(cartList));
        return "cartListInner";
    }


}
