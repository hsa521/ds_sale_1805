package com.mr.model;

import java.util.List;

/**
 * Created by yaodd on 2018/11/12.
 */
public class TMallOrderVO extends TMallOrder {

    //物流表的集合
    private List<TMallFlowVO> flowList;

    public List<TMallFlowVO> getFlowList() {
        return flowList;
    }

    public void setFlowList(List<TMallFlowVO> flowList) {
        this.flowList = flowList;
    }
}
