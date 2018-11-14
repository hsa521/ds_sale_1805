package com.mr.service;

import com.mr.model.TMallAddress;
import com.mr.model.TMallOrderVO;

import java.util.List;

/**
 * Created by ${ShenTao} on 2018/11/12.
 */
public interface OrderService {
    List<TMallAddress> listAddressByYhId(Integer id);

    void saveOrder(TMallOrderVO orderVO);
}
