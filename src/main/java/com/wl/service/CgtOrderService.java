package com.wl.service;

import com.wl.bean.CgtOrder;
import org.springframework.data.domain.Page;

/**
 * Created by wangliang on 2018/4/28.
 */
public interface CgtOrderService {

    public Page<CgtOrder> findByLoginName(String loginName, int pageNum, int pageSize);

    public CgtOrder addCgtOrder(CgtOrder cgtOrder);

}
