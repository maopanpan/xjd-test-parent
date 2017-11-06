package com.hz.xjd.app.user;

import com.alibaba.fastjson.JSON;
import com.hz.xjd.app.BaseTest;
import com.hz.xjd.biz.user.service.UserMobileService;
import com.hz.xjd.common.model.BaseResp;
import com.hz.xjd.common.vo.app.user.LoginBean;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by maopanpan on 2017/11/01.
 */
public class UserMobileTest extends BaseTest {

    private Logger logger = LoggerFactory.getLogger(UserMobileTest.class);

    @Autowired
    private UserMobileService userMobileService;


    @Test
    public void login() {
        LoginBean loginBean = new LoginBean();
        loginBean.setMobile("15011479990");
        loginBean.setVerifyCode("123456");
        BaseResp baseResp = userMobileService.login(loginBean);
        logger.info(JSON.toJSONString(baseResp));
    }
}
