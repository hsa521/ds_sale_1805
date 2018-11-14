package com.mr.mapper;

import com.mr.model.TMallAddress;
import com.mr.model.TMallFlowVO;
import com.mr.model.TMallOrderVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by ${ShenTao} on 2018/11/12.
 */
public interface OrderMapper {
    List<TMallAddress> listAddressByYhId(@Param("yhId") Integer id);

    void saveOrder(TMallOrderVO orderVO);

    void saveFlow(Map flowMap);

    void saveInfo(Map infoMap);

    void deleteCartByCarts(@Param("cartIds") List<Integer> cartIds);
}
