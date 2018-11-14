package com.mr.model;

public class TMallUserAccount {
    private Integer id;

    private String yhMch;

    private String yhNch;

    private String yhMm;

    private String yhXm;

    private String yhShjh;

    private String yhYx;

    private String yhTx;

    private String yhJb;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getYhMch() {
        return yhMch;
    }

    public void setYhMch(String yhMch) {
        this.yhMch = yhMch == null ? null : yhMch.trim();
    }

    public String getYhNch() {
        return yhNch;
    }

    public void setYhNch(String yhNch) {
        this.yhNch = yhNch == null ? null : yhNch.trim();
    }

    public String getYhMm() {
        return yhMm;
    }

    public void setYhMm(String yhMm) {
        this.yhMm = yhMm == null ? null : yhMm.trim();
    }

    public String getYhXm() {
        return yhXm;
    }

    public void setYhXm(String yhXm) {
        this.yhXm = yhXm == null ? null : yhXm.trim();
    }

    public String getYhShjh() {
        return yhShjh;
    }

    public void setYhShjh(String yhShjh) {
        this.yhShjh = yhShjh == null ? null : yhShjh.trim();
    }

    public String getYhYx() {
        return yhYx;
    }

    public void setYhYx(String yhYx) {
        this.yhYx = yhYx == null ? null : yhYx.trim();
    }

    public String getYhTx() {
        return yhTx;
    }

    public void setYhTx(String yhTx) {
        this.yhTx = yhTx == null ? null : yhTx.trim();
    }

    public String getYhJb() {
        return yhJb;
    }

    public void setYhJb(String yhJb) {
        this.yhJb = yhJb == null ? null : yhJb.trim();
    }
}