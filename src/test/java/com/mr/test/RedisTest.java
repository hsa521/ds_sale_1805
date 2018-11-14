package com.mr.test;

import com.mr.model.OBJECTAVVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by ${ShenTao} on 2018/11/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-redis.xml")
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test1(){

        //获取到购物车数据集合，将数据存放进去
        ValueOperations vot = redisTemplate.opsForValue();

        //vot.set("key2","value2");
        vot.set("key3","v3",100, TimeUnit.SECONDS);

        System.out.println(vot.get("key3"));

    }

    //给key1设置过期时间 ：expire

    @Test
    public void test2(){
        redisTemplate.expire("key1",100, TimeUnit.SECONDS);
    }

    //查看过期时间  ：ttl
    @Test
    public void test3(){
        System.out.println(redisTemplate.getExpire("key2"));
    }

    @Test
    public void test4(){
        System.out.println(redisTemplate.hasKey("key3"));
    }

    @Test
    public void test5(){
        List<OBJECTAVVO> list = new ArrayList<>();
        OBJECTAVVO vo = new OBJECTAVVO();
        vo.setShxMch("内存");
        vo.setShxZh("4G");
        list.add(vo);


        OBJECTAVVO vo1 = new OBJECTAVVO();
        vo1.setShxMch("处理器");
        vo1.setShxZh("i7");
        list.add(vo1);

        redisTemplate.opsForValue().set("cartList",list);

        System.out.println((List<OBJECTAVVO>)redisTemplate.opsForValue().get("cartList"));

    }

}
