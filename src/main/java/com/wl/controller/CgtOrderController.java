package com.wl.controller;

import com.wl.bean.CgtOrder;
import com.wl.bean.ResultBean;
import com.wl.bean.ResultCode;
import com.wl.service.CgtOrderService;
import com.wl.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by wangliang on 2018/4/28.
 */
@RestController
public class CgtOrderController {

    private static final Logger logger = LoggerFactory.getLogger(CgtOrderController.class);

    @Autowired
    private CgtOrderService cgtOrderService;

    @RequestMapping(value = "/v1/orders/{loginname}", method = RequestMethod.GET)
    public ResultBean findCgtOrderPage(@PathVariable("loginname") String loginName, @RequestParam String offset, @RequestParam String limit) {
        ResultBean resultBean = new ResultBean();
        try {
            logger.info("Call findCgtOrderPage Start, params:{}", "pageNum:" + offset + ",pageSize:" + limit);
            // 分页参数校验
            if (StringUtils.isEmpty(offset) || StringUtils.isEmpty(limit)) {
                resultBean.setResultCode(ResultCode.PARAM_NOT_COMPLETE);
                logger.info("Call findCgtOrderPage End, result:{}", JsonUtil.obj2json(resultBean));
                return resultBean;
            }
            int pageNum = Integer.parseInt(offset);
            int pageSize = Integer.parseInt(limit);
            if (pageNum < 1 || pageSize < 0) {
                resultBean.setResultCode(ResultCode.PARAM_IS_INVALID);
                logger.info("Call findCgtOrderPage End, result:{}", JsonUtil.obj2json(resultBean));
                return resultBean;
            }
            Page<CgtOrder> cgtOrderList = cgtOrderService.findByLoginName(loginName, pageNum - 1, pageSize);
            List<CgtOrder> resultList = cgtOrderList.getContent();
            if (resultList.size() == 0) {
                resultBean.setResultCode(ResultCode.RESULE_DATA_NONE);
                logger.info("Call findCgtOrderPage End, result:{}", JsonUtil.obj2json(resultBean));
                return resultBean;
            }
            resultBean.setResultCode(ResultCode.SUCCESS);
            resultBean.setData(resultList);
        } catch (Exception e) {
            logger.info("Call findCgtOrderPage occurs exception, caused by: ", e);
            resultBean.setResultCode(ResultCode.INTERFACE_INNER_INVOKE_ERROR);
        }
        return resultBean;
    }

    @RequestMapping(value = "/v1/order", method = RequestMethod.POST)
    public ResultBean addCgtOrder(@RequestParam String loginname, @RequestParam String money, @RequestParam String count, @RequestParam String date) {
        ResultBean resultBean = new ResultBean();
        try {
            logger.info("Call addCgtOrder Start, params:{}", "loginname:" + loginname + ",money:" + money + ",count:" + count + ",date:" + date);
            // 参数校验
            if (StringUtils.isEmpty(loginname) || StringUtils.isEmpty(money) || StringUtils.isEmpty(count) || StringUtils.isEmpty(date)) {
                resultBean.setResultCode(ResultCode.PARAM_NOT_COMPLETE);
                logger.info("Call addCgtOrder End, result:{}", JsonUtil.obj2json(resultBean));
                return resultBean;
            }
            CgtOrder cgtOrder = new CgtOrder();
            cgtOrder.setOrderId(date);
            cgtOrder.setLoginName(loginname);
            cgtOrder.setMoney(money);
            cgtOrder.setCount(Integer.parseInt(count));
            cgtOrder.setOrderTime(new SimpleDateFormat("yyyyMMdd").parse(date));
            CgtOrder resultCgtOrder = this.cgtOrderService.addCgtOrder(cgtOrder);
            if (resultCgtOrder == null) {
                resultBean.setResultCode(ResultCode.INTERFACE_INNER_INVOKE_ERROR);
                logger.info("Call addCgtOrder End, result:{}", JsonUtil.obj2json(resultBean));
                return resultBean;
            }
            resultBean.setResultCode(ResultCode.SUCCESS);
            resultBean.setData(resultCgtOrder);
        } catch (Exception e) {
            logger.info("Call addCgtOrder occurs exception, caused by: ", e);
            resultBean.setResultCode(ResultCode.INTERFACE_INNER_INVOKE_ERROR);
        }
        return resultBean;
    }

}
