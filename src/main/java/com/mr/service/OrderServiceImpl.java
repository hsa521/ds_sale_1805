package com.mr.service;

import com.mr.mapper.OrderMapper;
import com.mr.model.TMallAddress;
import com.mr.model.TMallFlowVO;
import com.mr.model.TMallOrderInfo;
import com.mr.model.TMallOrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ${ShenTao} on 2018/11/12.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<TMallAddress> listAddressByYhId(Integer id) {


        return orderMapper.listAddressByYhId(id);
    }

    /**
     * 增加订单
     * 将购物车中的数据下单到订单中
     * 增加订单之后要删除购物车中的数据
     * @param orderVO
     */
    @Override
    public void saveOrder(TMallOrderVO orderVO) {
        List<Integer> cartIds = new ArrayList<>();

        //增加order
        orderMapper.saveOrder(orderVO);

        //获取到order、然后增加List<flow>、for循环增加
        List<TMallFlowVO> flowList = orderVO.getFlowList();
        for (int i = 0; i < flowList.size(); i++) {
            Map flowMap = new HashMap();
            TMallFlowVO folwVo = flowList.get(i);
            flowMap.put("flow",folwVo);
            flowMap.put("orderId",orderVO.getId());
            orderMapper.saveFlow(flowMap);

            //增加orderInfo、批量增加
            List<TMallOrderInfo> infoList = flowList.get(i).getInfoList();
            Map infoMap = new HashMap();
            infoMap.put("infoList",infoList);
            infoMap.put("flowId",folwVo.getId());
            infoMap.put("orderId",orderVO.getId());
            orderMapper.saveInfo(infoMap);

            for (int s = 0; s < infoList.size(); s++) {
                TMallOrderInfo info = infoList.get(s);
                cartIds.add(info.getGwchId());
            }
        }
        //删除购物车
        orderMapper.deleteCartByCarts(cartIds);
    }
}
