package com.wl.repository;

import com.wl.bean.CgtOrderDetail;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by wangliang on 2018/5/2.
 */
public interface CgtOrderDetailRepository extends JpaRepository<CgtOrderDetail, Integer> {

    public List<CgtOrderDetail> findByOrderId(String orderId, Sort sort);

    public List<CgtOrderDetail> findByLoginNameAndOrderId(String loginName,String orderId, Sort sort);

}
