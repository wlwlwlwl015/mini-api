package com.wl.service.impl;

import com.wl.bean.SysUserInfo;
import com.wl.bean.TUser;
import com.wl.repository.SysUserInfoRepository;
import com.wl.repository.TUserRepository;
import com.wl.service.SysUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wangliang on 2018/4/19.
 */
@Service
public class SysUserInfoServiceImpl implements SysUserInfoService {

    @Autowired
    private SysUserInfoRepository sysUserInfoRepository;

    @Autowired
    private TUserRepository tUserRepository;

    @Override
    public boolean addSysUserInfo(SysUserInfo sysUserInfo, TUser tUser) {
        SysUserInfo saveSysUserInfo = sysUserInfoRepository.save(sysUserInfo);
        TUser saveTUser = tUserRepository.save(tUser);
        return (saveSysUserInfo != null && saveTUser != null) ? true : false;
    }

    @Override
    public SysUserInfo findByLoginName(String loginName) {
        return sysUserInfoRepository.findByLoginName(loginName);
    }

    @Override
    public SysUserInfo findByLoginNameOrPhoneNumber(String loginName, String phoneNumber) {
        return sysUserInfoRepository.findByLoginNameOrPhoneNumber(loginName, phoneNumber);
    }

}
