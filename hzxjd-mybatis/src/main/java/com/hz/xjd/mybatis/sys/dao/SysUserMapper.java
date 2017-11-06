package com.hz.xjd.mybatis.sys.dao;

import org.apache.ibatis.annotations.Param;

import com.hz.xjd.model.sys.entity.SysUser;
import tk.mybatis.mapper.common.Mapper;

public interface SysUserMapper extends Mapper<SysUser> {

	// 根据登录用户名称取得用户信息
	SysUser selectUserByLoginName(@Param("loginName") String loginName);
}