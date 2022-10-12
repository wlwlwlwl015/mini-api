package com.wl.service.impl;

import com.wl.bean.CgtOrder;
import com.wl.repository.CgtOrderRepository;
import com.wl.service.CgtOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * Created by wangliang on 2018/4/28.
 */
@Service
public class CgtOrderServiceImpl implements CgtOrderService {

    @Autowired
    private CgtOrderRepository cgtOrderRepository;

    @Override
    public Page<CgtOrder> findByLoginName(String loginName, int pageNum, int pageSize) {
        PageRequest pr = new PageRequest(pageNum, pageSize, Sort.Direction.DESC, "orderTime");
        return cgtOrderRepository.findByLoginName(loginName,pr);
    }

    @Override
    public CgtOrder addCgtOrder(CgtOrder cgtOrder) {
        return cgtOrderRepository.save(cgtOrder);
    }
}
