package com.wl.util;

import org.springframework.util.StringUtils;

/**
 * Created by wangliang on 2018/4/23.
 */
public class ValidationUtil {

    /**
     * 校验用户名(字母数字组合，8~16位)
     * @param param
     * @return
     */
    public static boolean loginNameValidate(String param){
        if(StringUtils.isEmpty(param)){
            return false;
        }
        if(!DataTypeHelper.isRightUserName(param)){
            return false;
        }
        return true;
    }

    /**
     * 校验密码字母数字组合，6~18位)
     * @param param
     * @return
     */
    public static boolean pwdValidate(String param){
        if(StringUtils.isEmpty(param)){
            return false;
        }
        if(!DataTypeHelper.isRightPwd(param)){
            return false;
        }
        return true;
    }

    /**
     * 校验手机号
     * @param param
     * @return
     */
    public static boolean phoneNumValidate(String param){
        if(StringUtils.isEmpty(param)){
            return false;
        }
        if(!DataTypeHelper.isMobile(param)){
            return false;
        }
        return true;
    }

    /**
     * 校验区域
     * @param param
     * @return
     */
    public static boolean areaValidate(String param){
        if(StringUtils.isEmpty(param)){
            return false;
        }
        if(param.equals("请选择")){
            return false;
        }
        return true;
    }

}
