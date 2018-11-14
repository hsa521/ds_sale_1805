package com.mr.model;

import java.util.List;

/**
 * Created by yaodd on 2018/11/7.
 */
public class TMallSkuItemVO extends TMallSku {

    //图片
    private List<TMallProductImage> imgList;

    private List<OBJECTAVVO> avList;

    public List<TMallProductImage> getImgList() {
        return imgList;
    }

    public void setImgList(List<TMallProductImage> imgList) {
        this.imgList = imgList;
    }

    public List<OBJECTAVVO> getAvList() {
        return avList;
    }

    public void setAvList(List<OBJECTAVVO> avList) {
        this.avList = avList;
    }
}
