package com.hz.xjd.biz.user.service;

import com.hz.xjd.common.model.BaseDataResp;
import com.hz.xjd.common.model.Result;
import com.hz.xjd.common.vo.app.user.LoginBean;
import com.hz.xjd.model.user.entity.UserMobile;

import java.util.Map;

/**
 * 操作用户账号
 */
public interface UserMobileService {


    /**
     * 用户登录
     *
     * @param loginBean
     */
    BaseDataResp login(LoginBean loginBean);

}
