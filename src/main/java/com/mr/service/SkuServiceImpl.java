package com.mr.service;

import com.mr.mapper.SkuMapper;
import com.mr.model.OBJECTSku;
import com.mr.model.TMallSku;
import com.mr.model.TMallSkuAttrValueVO;
import com.mr.model.TMallSkuItemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ${ShenTao} on 2018/11/6.
 */
@Service
public class SkuServiceImpl implements SkuService {

    @Autowired
    private SkuMapper skuMapper;

    @Override
    public List<OBJECTSku> listSkuByFlbh2(Integer flbh2) {
        return skuMapper.listSkuByFlbh2(flbh2);
    }

    @Override
    public List<OBJECTSku> listSkuByAttrAndClass2(TMallSkuAttrValueVO attrValueVO, Integer flbh2) {

        Map<String, Object> map = new HashMap<>();
        map.put("flbh2",flbh2);
        map.put("attrValueList",attrValueVO.getAttrValueList());

        return skuMapper.listSkuByAttrAndClass2(map);
    }

    @Override
    public List<TMallSku> listSkuBySpuId(Integer spuId) {
        return skuMapper.listSkuBySpuId(spuId);
    }

    @Override
    public TMallSkuItemVO listItemBySkuId(Integer skuId) {
        return skuMapper.listItemBySkuId(skuId);
    }

}
