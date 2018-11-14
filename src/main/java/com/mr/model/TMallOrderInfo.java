package com.mr.model;

import java.util.Date;

public class TMallOrderInfo {
    private Integer id;

    private Integer flowId;

    private Double skuJg;

    private Integer skuShl;

    private String skuKcdz;

    private Integer gwchId;

    private Integer ddId;

    private Integer skuId;

    private Date chjshj;

    private String skuMch;

    private String shpTp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFlowId() {
        return flowId;
    }

    public void setFlowId(Integer flowId) {
        this.flowId = flowId;
    }

    public Double getSkuJg() {
        return skuJg;
    }

    public void setSkuJg(Double skuJg) {
        this.skuJg = skuJg;
    }

    public Integer getSkuShl() {
        return skuShl;
    }

    public void setSkuShl(Integer skuShl) {
        this.skuShl = skuShl;
    }

    public String getSkuKcdz() {
        return skuKcdz;
    }

    public void setSkuKcdz(String skuKcdz) {
        this.skuKcdz = skuKcdz == null ? null : skuKcdz.trim();
    }

    public Integer getGwchId() {
        return gwchId;
    }

    public void setGwchId(Integer gwchId) {
        this.gwchId = gwchId;
    }

    public Integer getDdId() {
        return ddId;
    }

    public void setDdId(Integer ddId) {
        this.ddId = ddId;
    }

    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    public Date getChjshj() {
        return chjshj;
    }

    public void setChjshj(Date chjshj) {
        this.chjshj = chjshj;
    }

    public String getSkuMch() {
        return skuMch;
    }

    public void setSkuMch(String skuMch) {
        this.skuMch = skuMch == null ? null : skuMch.trim();
    }

    public String getShpTp() {
        return shpTp;
    }

    public void setShpTp(String shpTp) {
        this.shpTp = shpTp == null ? null : shpTp.trim();
    }
}