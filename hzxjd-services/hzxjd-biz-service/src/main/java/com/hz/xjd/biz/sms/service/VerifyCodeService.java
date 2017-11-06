package com.hz.xjd.biz.sms.service;

import com.hz.xjd.common.model.BaseDataResp;
import com.hz.xjd.common.vo.app.sms.VerifyCodeBean;

/**
 * Created by maopanpan on 2017/11/03.
 */
public interface VerifyCodeService {

    /**
     * 发送短信验证码
     *
     * @param verifyCodeBean
     * @return
     */
    public BaseDataResp sendSMSCode(VerifyCodeBean verifyCodeBean);
}