package com.hz.xjd.mybatis.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hz.xjd.model.sys.entity.SysUserRole;

import tk.mybatis.mapper.common.Mapper;

public interface SysUserRoleMapper extends Mapper<SysUserRole> {

	// 根据系统用户编号取得角色ID
	List<Integer> selectRoleBySysUserId(@Param("sysUserId") Integer sysUserId);
}