package com.wl.service;

import com.wl.bean.SysUserInfo;
import com.wl.bean.TUser;

/**
 * Created by wangliang on 2018/4/19.
 */
public interface SysUserInfoService {

    public boolean addSysUserInfo(SysUserInfo sysUserInfo, TUser tUser);

    public SysUserInfo findByLoginName(String loginName);

    public SysUserInfo findByLoginNameOrPhoneNumber(String loginName,String phoneNumber);

}
