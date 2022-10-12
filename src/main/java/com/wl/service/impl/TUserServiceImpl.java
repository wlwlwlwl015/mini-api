package com.wl.service.impl;

import com.wl.bean.TUser;
import com.wl.repository.TUserRepository;
import com.wl.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wangliang on 2018/5/5.
 */
@Service
public class TUserServiceImpl implements TUserService {

    @Autowired
    private TUserRepository tUserRepository;

    @Override
    public TUser addTUser(TUser tUser) {
        return tUserRepository.save(tUser);
    }

}
