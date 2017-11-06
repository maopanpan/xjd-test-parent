package com.hz.xjd.mybatis.sys.dao;

import org.apache.ibatis.annotations.Param;

import com.hz.xjd.model.sys.entity.SysFunction;

import tk.mybatis.mapper.common.Mapper;

public interface SysFunctionMapper extends Mapper<SysFunction> {
	/**
	 * 取得功能信息
	 * @param roleId
	 * @return
	 */
	SysFunction selectByFunctionId(@Param("functionId") Integer functionId);
}