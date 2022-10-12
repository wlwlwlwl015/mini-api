package com.wl.service;

import com.wl.bean.CgtOrderDetail;

import java.util.List;

/**
 * Created by wangliang on 2018/5/2.
 */
public interface CgtOrderDetailService {

    public List<CgtOrderDetail> findByOrderId(String orderId);

    public List<CgtOrderDetail> findByLoginNameAndOrderId(String loginName,String orderId);
}
