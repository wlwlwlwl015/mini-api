package com.wl.repository;

import com.wl.bean.CgtOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by wangliang on 2018/4/28.
 */
public interface CgtOrderRepository extends JpaRepository<CgtOrder, Integer> {

    public List<CgtOrder> findByLoginName(String loginName);

    public Page<CgtOrder> findByLoginName(String loginName, Pageable pageable);

}
