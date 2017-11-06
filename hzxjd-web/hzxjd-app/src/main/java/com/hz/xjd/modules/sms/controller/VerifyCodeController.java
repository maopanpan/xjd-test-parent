package com.hz.xjd.modules.sms.controller;

import com.hz.xjd.app.web.controller.AppBaseController;
import com.hz.xjd.biz.sms.service.VerifyCodeService;
import com.hz.xjd.common.constants.IResultsCode;
import com.hz.xjd.common.model.BaseDataResp;
import com.hz.xjd.common.vo.app.sms.VerifyCodeBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: maopanpan
 * @Description: 生成短信验证码
 * @Date: 2017/11/03.
 **/
@Controller
@RequestMapping("/sms")
public class VerifyCodeController extends AppBaseController {

    private Logger logger = LoggerFactory.getLogger(VerifyCodeController.class);

    @Autowired
    private VerifyCodeService verifyCodeService;

    @RequestMapping(value = "/{v}/sendSMSCode", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Object sendSMSCode(HttpServletRequest request, @PathVariable String v, HttpEntity<VerifyCodeBean> httpEntity) {
        logger.info("【短信】请求参数：" + httpEntity.getBody());

        BaseDataResp resp = this.validator(httpEntity);
        if (!IResultsCode.SUCCESS.getKey().equals(resp.getCode())) {
            logger.error("【短信】请求参数校验异常:" + resp);
            return resp;
        }
        //获取参数
        VerifyCodeBean verifyCodeBean = httpEntity.getBody();
        //手机号
        String mobile = verifyCodeBean.getMobile();
        //短信模板
        String templateNo = verifyCodeBean.getTemplateNo();

        if (StringUtils.isEmpty(mobile)) {
            logger.error("【短信】手机号不能为空");
            resp.setCode(IResultsCode.ERROR_PARAMETER, "手机号不能为空");
            return resp;
        }

        if (StringUtils.isEmpty(templateNo)) {
            logger.error("【短信】短信模板不能为空");
            resp.setCode(IResultsCode.ERROR_PARAMETER, "短信模板不能为空");
            return resp;
        }

        resp = verifyCodeService.sendSMSCode(verifyCodeBean);

        return resp;

    }


}
