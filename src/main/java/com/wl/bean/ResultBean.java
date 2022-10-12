package com.wl.bean;

/**
 * Created by wangliang on 2018/4/20.
 */
public class ResultBean {

    private Integer code;

    private String msg;

    private Object data;

    public ResultBean() {
    }

    public ResultBean(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ResultBean success(Object data) {
        ResultBean resultBean = new ResultBean();
        resultBean.setResultCode(ResultCode.SUCCESS);
        resultBean.setData(data);
        return resultBean;
    }

    public static ResultBean failure(ResultCode resultCode) {
        ResultBean result = new ResultBean();
        result.setResultCode(resultCode);
        return result;
    }

    public static ResultBean failure(ResultCode resultCode, Object data) {
        ResultBean result = new ResultBean();
        result.setResultCode(resultCode);
        result.setData(data);
        return result;
    }


    public void setResultCode(ResultCode code) {
        this.code = code.code();
        this.msg = code.message();
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }
}
