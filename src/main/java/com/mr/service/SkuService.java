package com.mr.service;

import com.mr.model.OBJECTSku;
import com.mr.model.TMallSku;
import com.mr.model.TMallSkuAttrValueVO;
import com.mr.model.TMallSkuItemVO;

import java.util.List;

/**
 * Created by ${ShenTao} on 2018/11/6.
 */
public interface SkuService {
    List<OBJECTSku> listSkuByFlbh2(Integer flbh2);

    List<OBJECTSku> listSkuByAttrAndClass2(TMallSkuAttrValueVO attrValueVO, Integer flbh2);

    List<TMallSku> listSkuBySpuId(Integer spuId);

    TMallSkuItemVO listItemBySkuId(Integer skuId);
}
