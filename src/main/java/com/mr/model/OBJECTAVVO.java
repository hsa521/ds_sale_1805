package com.mr.model;

import lombok.ToString;

import java.io.Serializable;

/**
 * 商品详情
 * 属性名和属性值
 *
 * Created by yaodd on 2018/11/7.
 */
@ToString
public class OBJECTAVVO implements Serializable{

    //属性名
    private String shxMch;

    //属性值
    private String shxZh;

    public String getShxMch() {
        return shxMch;
    }

    public void setShxMch(String shxMch) {
        this.shxMch = shxMch;
    }

    public String getShxZh() {
        return shxZh;
    }

    public void setShxZh(String shxZh) {
        this.shxZh = shxZh;
    }
}
