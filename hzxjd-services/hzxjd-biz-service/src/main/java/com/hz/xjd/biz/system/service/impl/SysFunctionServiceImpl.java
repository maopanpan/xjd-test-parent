package com.hz.xjd.biz.system.service.impl;

import org.springframework.stereotype.Service;

import com.hz.xjd.biz.base.service.BaseService;
import com.hz.xjd.biz.system.service.SysFunctionService;
import com.hz.xjd.model.sys.entity.SysFunction;
import com.hz.xjd.mybatis.sys.dao.SysFunctionMapper;

@Service
public class SysFunctionServiceImpl extends BaseService<SysFunctionMapper, SysFunction> implements SysFunctionService{

}
