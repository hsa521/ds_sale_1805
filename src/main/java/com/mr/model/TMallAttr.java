package com.mr.model;

import lombok.ToString;

import java.util.Date;

@ToString
public class TMallAttr {
    private Integer id;

    private String shxmMch;

    private String shfqy;

    private Integer flbh2;

    private Date chjshj;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShxmMch() {
        return shxmMch;
    }

    public void setShxmMch(String shxmMch) {
        this.shxmMch = shxmMch == null ? null : shxmMch.trim();
    }

    public String getShfqy() {
        return shfqy;
    }

    public void setShfqy(String shfqy) {
        this.shfqy = shfqy == null ? null : shfqy.trim();
    }

    public Integer getFlbh2() {
        return flbh2;
    }

    public void setFlbh2(Integer flbh2) {
        this.flbh2 = flbh2;
    }

    public Date getChjshj() {
        return chjshj;
    }

    public void setChjshj(Date chjshj) {
        this.chjshj = chjshj;
    }
}