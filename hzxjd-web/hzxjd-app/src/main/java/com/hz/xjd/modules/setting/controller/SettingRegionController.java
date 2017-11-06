package com.hz.xjd.modules.setting.controller;

import com.hz.xjd.app.web.controller.AppBaseController;
import com.hz.xjd.biz.setting.service.SettingRegionService;
import com.hz.xjd.common.constants.IResultsCode;
import com.hz.xjd.common.model.BaseDataResp;
import com.hz.xjd.common.vo.app.setting.RegionBean;
import com.hz.xjd.model.setting.entity.SettingRegion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @Author: maopanpan
 * @Description: 读取省市区
 * @Date: 2017/11/03.
 **/
@Controller
@RequestMapping("/setting")
public class SettingRegionController extends AppBaseController {

    private Logger logger = LoggerFactory.getLogger(SettingRegionController.class);

    @Autowired
    private SettingRegionService settingRegionService;

    @RequestMapping(value = "/{v}/getRegions", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Object getRegions(HttpServletRequest request, @PathVariable String v, HttpEntity<RegionBean> httpEntity) {
        logger.info("【区域配置】请求参数：" + httpEntity.getBody());

        BaseDataResp resp = this.validator(httpEntity);
        if (!IResultsCode.SUCCESS.getKey().equals(resp.getCode())) {
            logger.error("【区域配置】请求参数校验异常:" + resp);
            return resp;
        }

        int pCode = 0;
        if (!StringUtils.isEmpty(httpEntity.getBody().getpCode())) {
            pCode = Integer.parseInt(httpEntity.getBody().getpCode());
        }

        /**
         * 获取区域信息
         * 省
         * *市
         * **区
         */
        List<Map<String, Object>> regions = settingRegionService.selectRegions(pCode);
        resp.setCode(IResultsCode.SUCCESS);
        resp.setData(regions);

        return resp;
    }

}
