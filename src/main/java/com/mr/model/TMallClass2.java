package com.mr.model;

public class TMallClass2 {
    private Integer id;

    private String flmch2;

    private Integer flbh1;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFlmch2() {
        return flmch2;
    }

    public void setFlmch2(String flmch2) {
        this.flmch2 = flmch2 == null ? null : flmch2.trim();
    }

    public Integer getFlbh1() {
        return flbh1;
    }

    public void setFlbh1(Integer flbh1) {
        this.flbh1 = flbh1;
    }
}