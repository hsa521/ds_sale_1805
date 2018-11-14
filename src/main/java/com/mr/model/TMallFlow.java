package com.mr.model;

import java.util.Date;

public class TMallFlow {
    private Integer id;

    private String psfsh;

    private Date psshj;

    private String psmsh;

    private Integer yhId;

    private Date chjshj;

    private Integer ddId;

    private String mqdd;

    private String mdd;

    private String ywy;

    private String lxfsh;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPsfsh() {
        return psfsh;
    }

    public void setPsfsh(String psfsh) {
        this.psfsh = psfsh == null ? null : psfsh.trim();
    }

    public Date getPsshj() {
        return psshj;
    }

    public void setPsshj(Date psshj) {
        this.psshj = psshj;
    }

    public String getPsmsh() {
        return psmsh;
    }

    public void setPsmsh(String psmsh) {
        this.psmsh = psmsh == null ? null : psmsh.trim();
    }

    public Integer getYhId() {
        return yhId;
    }

    public void setYhId(Integer yhId) {
        this.yhId = yhId;
    }

    public Date getChjshj() {
        return chjshj;
    }

    public void setChjshj(Date chjshj) {
        this.chjshj = chjshj;
    }

    public Integer getDdId() {
        return ddId;
    }

    public void setDdId(Integer ddId) {
        this.ddId = ddId;
    }

    public String getMqdd() {
        return mqdd;
    }

    public void setMqdd(String mqdd) {
        this.mqdd = mqdd == null ? null : mqdd.trim();
    }

    public String getMdd() {
        return mdd;
    }

    public void setMdd(String mdd) {
        this.mdd = mdd == null ? null : mdd.trim();
    }

    public String getYwy() {
        return ywy;
    }

    public void setYwy(String ywy) {
        this.ywy = ywy == null ? null : ywy.trim();
    }

    public String getLxfsh() {
        return lxfsh;
    }

    public void setLxfsh(String lxfsh) {
        this.lxfsh = lxfsh == null ? null : lxfsh.trim();
    }
}