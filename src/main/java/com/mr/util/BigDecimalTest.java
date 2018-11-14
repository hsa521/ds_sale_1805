package com.mr.util;

import java.math.BigDecimal;

/**
 *
 * 在对金额计算的时候,需要使用 BigDecimal
 *
 * Created by shentao on 2018/11/8.
 */
public class BigDecimalTest {

    public static void main(String[] args) {

        BigDecimal b1 = new BigDecimal("0.2");//string
        BigDecimal b2 = new BigDecimal(0.2d);//double
        BigDecimal b3 = new BigDecimal(0.2f);//f

        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);

        BigDecimal b4 = new BigDecimal("3");//string
        BigDecimal b5 = new BigDecimal("10");//string

        //加
        BigDecimal add = b4.add(b5);
        System.out.println(add);

        //减
        BigDecimal subtract = b4.subtract(b5);
        System.out.println(subtract);

        //乘
        System.out.println(b4.multiply(b5));

        //除
        System.out.println(b5.divide(b4,2,BigDecimal.ROUND_HALF_DOWN));
    }
}
