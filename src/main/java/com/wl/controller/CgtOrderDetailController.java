package com.wl.controller;

import com.wl.bean.CgtOrderDetail;
import com.wl.bean.ResultBean;
import com.wl.bean.ResultCode;
import com.wl.service.CgtOrderDetailService;
import com.wl.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by wangliang on 2018/5/2.
 */
@RestController
public class CgtOrderDetailController {

    private static final Logger logger = LoggerFactory.getLogger(CgtOrderDetailController.class);

    @Autowired
    private CgtOrderDetailService cgtOrderDetailService;

    @RequestMapping(value = "/v1/orderdetail/{loginname}", method = RequestMethod.GET)
    public ResultBean findCgtOrderDetailById(@PathVariable("loginname") String loginname, @RequestParam(name="orderId") String orderId) {
        ResultBean resultBean = new ResultBean();
        try {
            logger.info("Call findCgtOrderDetailById Start, params:{}", "orderId:" + orderId);
            if(StringUtils.isEmpty(loginname) || StringUtils.isEmpty(orderId)){
                resultBean.setResultCode(ResultCode.PARAM_NOT_COMPLETE);
                logger.info("Call findCgtOrderDetailById End, result:{}", JsonUtil.obj2json(resultBean));
                return resultBean;
            }
            List<CgtOrderDetail> resultList = this.cgtOrderDetailService.findByLoginNameAndOrderId(loginname,orderId);
            if(resultList == null || resultList.size() == 0){
                resultBean.setResultCode(ResultCode.RESULE_DATA_NONE);
                logger.info("Call findCgtOrderDetailById End, result:{}", JsonUtil.obj2json(resultBean));
                return resultBean;
            }
            resultBean.setResultCode(ResultCode.SUCCESS);
            resultBean.setData(resultList);
        } catch (Exception e) {
            logger.info("Call findCgtOrderDetailById occurs exception, caused by: ", e);
            resultBean.setResultCode(ResultCode.INTERFACE_INNER_INVOKE_ERROR);
        }
        return resultBean;
    }
}
