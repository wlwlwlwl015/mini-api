package com.wl.repository;

import com.wl.bean.SysUserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wangliang on 2018/4/19.
 */
public interface SysUserInfoRepository extends JpaRepository<SysUserInfo,Integer> {

    public SysUserInfo findByLoginName(String loginName);

    public SysUserInfo findByLoginNameOrPhoneNumber(String loginName,String phoneNumber);

}
