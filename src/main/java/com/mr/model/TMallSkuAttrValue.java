package com.mr.model;

import java.util.Date;

public class TMallSkuAttrValue {
    private Integer id;

    private Integer shxmId;

    private Integer shxzhId;

    private Integer shpId;

    private String isSku;

    private Date chjshj;

    private Integer skuId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShxmId() {
        return shxmId;
    }

    public void setShxmId(Integer shxmId) {
        this.shxmId = shxmId;
    }

    public Integer getShxzhId() {
        return shxzhId;
    }

    public void setShxzhId(Integer shxzhId) {
        this.shxzhId = shxzhId;
    }

    public Integer getShpId() {
        return shpId;
    }

    public void setShpId(Integer shpId) {
        this.shpId = shpId;
    }

    public String getIsSku() {
        return isSku;
    }

    public void setIsSku(String isSku) {
        this.isSku = isSku == null ? null : isSku.trim();
    }

    public Date getChjshj() {
        return chjshj;
    }

    public void setChjshj(Date chjshj) {
        this.chjshj = chjshj;
    }

    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }
}