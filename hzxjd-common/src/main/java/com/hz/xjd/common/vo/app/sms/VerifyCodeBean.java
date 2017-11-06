package com.hz.xjd.common.vo.app.sms;

import com.alibaba.fastjson.JSON;
import com.hz.xjd.common.model.BaseReq;
import org.hibernate.validator.constraints.NotBlank;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Author: maopanpan
 * @Description: 短信接口定义
 * @Date: 2017/11/03.
 **/
@XmlRootElement
public class VerifyCodeBean extends BaseReq {

    /**
     * 手机号
     */
    @NotBlank
    String mobile;

    /**
     * 短信模板编号
     */
    @NotBlank
    String templateNo;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTemplateNo() {
        return templateNo;
    }

    public void setTemplateNo(String templateNo) {
        this.templateNo = templateNo;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
