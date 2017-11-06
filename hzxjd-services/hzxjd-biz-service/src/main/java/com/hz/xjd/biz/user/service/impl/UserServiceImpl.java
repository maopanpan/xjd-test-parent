package com.hz.xjd.biz.user.service.impl;

import org.springframework.stereotype.Service;

import com.hz.xjd.biz.base.service.BaseService;
import com.hz.xjd.biz.user.service.UserService;
import com.hz.xjd.model.user.entity.User;
import com.hz.xjd.mybatis.user.dao.UserMapper;

@Service
public class UserServiceImpl extends BaseService<UserMapper, User> implements UserService {

}
