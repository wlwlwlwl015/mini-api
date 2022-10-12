package com.wl.repository;

import com.wl.bean.Cgt;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by wangliang on 2018/5/6.
 */
public interface CgtRepository extends JpaRepository<Cgt, Integer> {

    public List<Cgt> findByIsTop(Integer isTop, Sort sort);

    public Cgt findByCgtCode(String cgtCode);

}
