package com.wl.service.impl;

import com.wl.bean.Cgt;
import com.wl.bean.CgtOrderDetail;
import com.wl.repository.CgtOrderDetailRepository;
import com.wl.repository.CgtRepository;
import com.wl.service.CgtOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by wangliang on 2018/5/2.
 */
@Service
public class CgtOrderDetailServiceImpl implements CgtOrderDetailService {

    @Autowired
    private CgtOrderDetailRepository cgtOrderDetailRepository;

    @Autowired
    private CgtRepository cgtRepository;

    @Override
    public List<CgtOrderDetail> findByOrderId(String orderId) {
        return cgtOrderDetailRepository.findByOrderId(orderId, new Sort(Sort.Direction.ASC, "cgtSeq"));
    }

    @Override
    public List<CgtOrderDetail> findByLoginNameAndOrderId(String loginName, String orderId) {
        List<CgtOrderDetail> cgtOrderDetailList = cgtOrderDetailRepository.findByLoginNameAndOrderId(loginName, orderId, new Sort(Sort.Direction.ASC, "cgtSeq"));
        for (CgtOrderDetail cgtOrder : cgtOrderDetailList) {
            // 如果图片路径不存在，则根据cgtCode联查cgt的img_url并更新5-
            String imgUrl = cgtOrder.getImgUrl();
            if (StringUtils.isEmpty(imgUrl)) {
                Cgt cgt = cgtRepository.findByCgtCode(cgtOrder.getCgtCode());
                if (!StringUtils.isEmpty(cgt.getImgUrl())) {
                    // 更新订单详情记录的imgUrl
                    cgtOrder.setImgUrl(cgt.getImgUrl());
                    cgtOrderDetailRepository.save(cgtOrder);
                }
            }
        }
        return cgtOrderDetailList;
    }

}
