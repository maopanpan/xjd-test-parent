package com.hz.xjd.common.vo.app.user;

import com.alibaba.fastjson.JSONObject;
import com.hz.xjd.common.model.BaseReq;
import org.hibernate.validator.constraints.NotBlank;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Author: maopanpan
 * @Description: 用户登录定义
 * @Date: 2017/11/03.
 **/
@XmlRootElement
public class LoginBean extends BaseReq {
    /**
     * 手机号（登录账户）
     */
    @NotBlank
    private String mobile;

    /**
     * 验证码
     */
    @NotBlank
    private String verifyCode;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
