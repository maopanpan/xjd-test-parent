package com.hz.xjd.mybatis.user.dao;

import com.hz.xjd.model.user.entity.User;
import com.hz.xjd.model.user.entity.UserMobile;
import tk.mybatis.mapper.common.Mapper;

import java.util.Map;

/**
 * 用户登录信息
 */
public interface UserMobileMapper extends Mapper<UserMobile> {

    /**
     * 通过手机号，查询登录账号
     *
     * @param params
     * @return
     */
    UserMobile selectUserByMobile(Map<String, Object> params);

    /**
     * 通过用户ID，更新最后登录时间
     *
     * @param params
     */
    void updateLastLoginTime(Map<String, Object> params);
}