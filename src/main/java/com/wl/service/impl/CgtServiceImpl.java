package com.wl.service.impl;

import com.wl.bean.Cgt;
import com.wl.repository.CgtRepository;
import com.wl.service.CgtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wangliang on 2018/5/6.
 */
@Service("cgtService")
public class CgtServiceImpl implements CgtService {

    @Autowired
    private CgtRepository cgtRepository;


    @Override
    public List<Cgt> findByIsTop() {
        return cgtRepository.findByIsTop(1, new Sort(Sort.Direction.ASC, "id"));
    }

    @Override
    public List<Cgt> findByIsNotTop() {
        return cgtRepository.findByIsTop(0, new Sort(Sort.Direction.ASC, "id"));
    }

}
