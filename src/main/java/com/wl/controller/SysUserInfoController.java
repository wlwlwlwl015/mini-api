package com.wl.controller;

import com.wl.bean.ResultBean;
import com.wl.bean.ResultCode;
import com.wl.bean.SysUserInfo;
import com.wl.bean.TUser;
import com.wl.enumm.UserStatus;
import com.wl.service.SysUserInfoService;
import com.wl.util.JsonUtil;
import com.wl.util.MD5Util;
import com.wl.util.ValidationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.UUID;

/**
 * Created by wangliang on 2018/4/19.
 */
@RestController
public class SysUserInfoController {

    private static final Logger logger = LoggerFactory.getLogger(SysUserInfoController.class);

    @Autowired
    private SysUserInfoService sysUserInfoService;

    @RequestMapping(value = "/session", method = RequestMethod.POST)
    public ResultBean createSession(@RequestBody SysUserInfo sysUserInfo, HttpServletRequest request) {
        ResultBean resultBean = new ResultBean();
        try {
            logger.info("Call createSession Start, params:{}", JsonUtil.obj2json(sysUserInfo));
            String loginName = sysUserInfo.getLoginName();
            String pwd = sysUserInfo.getPwd();
            // 客户端参数校验
            if (StringUtils.isEmpty(loginName) || StringUtils.isEmpty(pwd)) {
                resultBean.setResultCode(ResultCode.PARAM_NOT_COMPLETE_LOGIN_NAME_AND_PWD);
                logger.info("Call createSession End, result:{}", JsonUtil.obj2json(resultBean));
                return resultBean;
            }
            // 检查用户名是否存在
            SysUserInfo sUserInfo = this.sysUserInfoService.findByLoginName(loginName);
            if (sUserInfo == null) {
                resultBean.setResultCode(ResultCode.USER_NOT_EXIST);
                logger.info("Call createSession End, result:{}", JsonUtil.obj2json(resultBean));
                return resultBean;
            }
            // 检查用户账号是否停用
            if (sUserInfo.getStatus() == UserStatus.DISABLE) {
                resultBean.setResultCode(ResultCode.USER_WAIT_FOR_AUDIT);
                logger.info("Call createSession End, result:{}", JsonUtil.obj2json(resultBean));
                return resultBean;
            }
            // 检查密码
            if(!MD5Util.MD5Salt(pwd, sUserInfo.getSalt()).equals(sUserInfo.getAfPwd())){
                resultBean.setResultCode(ResultCode.USER_LOGIN_ERROR);
                logger.info("Call createSession End, result:{}", JsonUtil.obj2json(resultBean));
                return resultBean;
            }
            // 登录成功
            sUserInfo.setSessionId(request.getSession().getId());
            resultBean.setResultCode(ResultCode.SUCCESS);
            resultBean.setData(sUserInfo);
        } catch (Exception e) {
            logger.info("Call createSession occurs exception, caused by: ", e);
            resultBean.setResultCode(ResultCode.INTERFACE_INNER_INVOKE_ERROR);
        }
        return resultBean;
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResultBean createUserInfo(@RequestBody SysUserInfo sysUserInfo) {
        ResultBean resultBean = new ResultBean();
        try {
            logger.info("Call createUserInfo Start, params:{}", JsonUtil.obj2json(sysUserInfo));
            // 参数校验
            // 用户名
            if (!ValidationUtil.loginNameValidate(sysUserInfo.getLoginName())) {
                resultBean.setResultCode(ResultCode.PARAM_NOT_COMPLETE_LOGIN_NAME);
                logger.info("Call createUserInfo End, result:{}", JsonUtil.obj2json(resultBean));
                return resultBean;
            }
            // 手机号
            if (!ValidationUtil.phoneNumValidate(sysUserInfo.getPhoneNumber())) {
                resultBean.setResultCode(ResultCode.PARAM_NOT_COMPLETE_PHONE_NUM);
                logger.info("Call createUserInfo End, result:{}", JsonUtil.obj2json(resultBean));
                return resultBean;
            }
            // 商铺名
            if (StringUtils.isEmpty(sysUserInfo.getShopName())) {
                resultBean.setResultCode(ResultCode.PARAM_NOT_COMPLETE_SHOP_NAME);
                logger.info("Call createUserInfo End, result:{}", JsonUtil.obj2json(resultBean));
                return resultBean;
            }
            // 密码
            if (!ValidationUtil.pwdValidate(sysUserInfo.getPwd())) {
                resultBean.setResultCode(ResultCode.PARAM_NOT_COMPLETE_PWD);
                logger.info("Call createUserInfo End, result:{}", JsonUtil.obj2json(resultBean));
                return resultBean;
            }
            // 区域
            if (!ValidationUtil.areaValidate(sysUserInfo.getAreaInfo())) {
                resultBean.setResultCode(ResultCode.PARAM_NOT_COMPLETE_AREA);
                logger.info("Call createUserInfo End, result:{}", JsonUtil.obj2json(resultBean));
                return resultBean;
            }
            // 详细地址
            if (StringUtils.isEmpty(sysUserInfo.getAddress())) {
                resultBean.setResultCode(ResultCode.PARAM_NOT_COMPLETE_ADDRESS);
                logger.info("Call createUserInfo End, result:{}", JsonUtil.obj2json(resultBean));
                return resultBean;
            }
            // 检查用户名和手机号是否重复
            SysUserInfo resultUser = sysUserInfoService.findByLoginNameOrPhoneNumber(sysUserInfo.getLoginName(), sysUserInfo.getPhoneNumber());
            if (resultUser != null) {
                resultBean.setResultCode(ResultCode.USER_HAS_EXISTED);
                logger.info("Call createUserInfo End, result:{}", JsonUtil.obj2json(resultBean));
                return resultBean;
            }
            // 添加用户
            String salt = UUID.randomUUID().toString();
            sysUserInfo.setSalt(salt);
            sysUserInfo.setAfPwd(MD5Util.MD5Salt(sysUserInfo.getPwd(), salt));
            sysUserInfo.setCreateTime(new Date());
            // 同时给sys_user_info和t_user均要插入1条数据
            TUser tUser = new TUser();
            tUser.setLoginid(sysUserInfo.getLoginName());
            tUser.setPassword(sysUserInfo.getPwd());
            tUser.setRealname(sysUserInfo.getRealName());
            tUser.setStatus(UserStatus.DISABLE.getIndex());
            boolean result = sysUserInfoService.addSysUserInfo(sysUserInfo,tUser);
            if (!result) {
                logger.info("Call createUserInfo End, Method failed");
                resultBean.setResultCode(ResultCode.INTERFACE_INNER_INVOKE_ERROR);
            } else {
                resultBean.setResultCode(ResultCode.SUCCESS);
            }
        } catch (Exception e) {
            logger.info("Call createUserInfo occurs exception, caused by: ", e);
            resultBean.setResultCode(ResultCode.INTERFACE_INNER_INVOKE_ERROR);
        }
        return resultBean;
    }
}
