package com.wl.service;

import com.wl.bean.Cgt;

import java.util.List;

/**
 * Created by wangliang on 2018/5/6.
 */
public interface CgtService {

    public List<Cgt> findByIsTop();

    public List<Cgt> findByIsNotTop();
}
