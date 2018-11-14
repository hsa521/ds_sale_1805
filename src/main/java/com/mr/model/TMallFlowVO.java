package com.mr.model;

import java.util.List;

/**
 * Created by yaodd on 2018/11/12.
 */
public class TMallFlowVO extends TMallFlow{

    private List<TMallOrderInfo> infoList;

    public List<TMallOrderInfo> getInfoList() {
        return infoList;
    }

    public void setInfoList(List<TMallOrderInfo> infoList) {
        this.infoList = infoList;
    }
}
