package com.hz.xjd.biz.system.service.impl;

import org.springframework.stereotype.Service;

import com.hz.xjd.biz.base.service.BaseService;
import com.hz.xjd.biz.system.service.SysUserService;
import com.hz.xjd.model.sys.entity.SysUser;
import com.hz.xjd.mybatis.sys.dao.SysUserMapper;

@Service
public class SysUserServiceImpl extends BaseService<SysUserMapper, SysUser> implements SysUserService{

}
