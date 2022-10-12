package com.wl.controller;

import com.wl.bean.Cgt;
import com.wl.bean.ResultBean;
import com.wl.bean.ResultCode;
import com.wl.service.CgtService;
import com.wl.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangliang on 2018/5/6.
 */
@RestController
public class CgtController {

    private static final Logger logger = LoggerFactory.getLogger(CgtController.class);

    @Autowired
    private CgtService cgtService;

    @RequestMapping(value = "/v1/cgt", method = RequestMethod.GET)
    public ResultBean findCgtList() {
        ResultBean resultBean = new ResultBean();
        try {
            logger.info("Call findCgtList Start");
            List<Cgt> allList = new ArrayList<>();
            List<Cgt> topDataList = cgtService.findByIsTop();
            List<Cgt> otherDataList = cgtService.findByIsNotTop();
            allList.addAll(topDataList);
            allList.addAll(otherDataList);
            if(allList.size() == 0){
                resultBean.setResultCode(ResultCode.RESULE_DATA_NONE);
                logger.info("Call findCgtList End, result:{}", JsonUtil.obj2json(resultBean));
                return resultBean;
            }
            resultBean.setResultCode(ResultCode.SUCCESS);
            resultBean.setData(allList);
        } catch (Exception e) {
            logger.info("Call findCgtOrderDetailById occurs exception, caused by: ", e);
            resultBean.setResultCode(ResultCode.INTERFACE_INNER_INVOKE_ERROR);
        }
        return resultBean;
    }
}
