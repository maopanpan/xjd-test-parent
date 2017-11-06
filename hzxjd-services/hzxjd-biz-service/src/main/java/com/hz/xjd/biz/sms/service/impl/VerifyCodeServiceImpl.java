package com.hz.xjd.biz.sms.service.impl;

import com.hz.xjd.biz.setting.service.SettingTemplateService;
import com.hz.xjd.biz.sms.service.VerifyCodeService;
import com.hz.xjd.common.constants.Constants;
import com.hz.xjd.common.constants.IResultsCode;
import com.hz.xjd.common.model.BaseDataResp;
import com.hz.xjd.common.vo.app.sms.VerifyCodeBean;
import com.hz.xjd.manager.RedisManager;
import com.hz.xjd.model.setting.entity.SettingTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @Author: maopanpan
 * @Description: 短信验证码
 * @Date: 2017/11/03.
 **/
@Service
public class VerifyCodeServiceImpl implements VerifyCodeService {
    private Logger logger = LoggerFactory.getLogger(VerifyCodeServiceImpl.class);


    @Autowired
    private RedisManager redisManager;

    /**
     * 数据模板
     */
    @Autowired
    private SettingTemplateService settingTemplateService;

    /**
     * 发送短信验证码
     *
     * @param verifyCodeBean
     * @return
     */
    @Override
    public BaseDataResp sendSMSCode(VerifyCodeBean verifyCodeBean) {
        //手机号
        String mobile = verifyCodeBean.getMobile();
        //短信模板
        String templateNo = verifyCodeBean.getTemplateNo();

        BaseDataResp dataResp = new BaseDataResp();
        try {

            /**
             * 获取短信模板
             */
            SettingTemplate settingTemplate = settingTemplateService.selectSettingByTemplateNo("msg", templateNo);
            if (settingTemplate == null) {
                logger.error("【短信】{}短信模板不存在", templateNo);
                dataResp.setCode(IResultsCode.ERROR_PARAMETER, "短信模板不存在");
                return dataResp;
            }

            String template = settingTemplate.getContent();
            //生成四位验证码
            int smsCode = (int) ((Math.random() * 9 + 1) * 1000);
            //生成短信内容
            String smsContext = String.format(template, smsCode);

            /**
             * 将短信验证码存储到Redis
             */
            String key = Constants.VALIDATE_CODE + ":" + mobile;
            redisManager.set(Constants.vIndex, key, Constants.SMS_LIVE_TIME, smsCode);

            //短信发送

            dataResp.setCode(IResultsCode.SUCCESS);
            return dataResp;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("【短信】短信发送失败", e);
            dataResp.setCode(IResultsCode.ERROR_UNKNOWN);
            return dataResp;
        }
    }

}
