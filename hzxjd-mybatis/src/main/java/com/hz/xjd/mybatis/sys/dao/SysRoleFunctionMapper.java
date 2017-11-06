package com.hz.xjd.mybatis.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hz.xjd.model.sys.entity.SysRoleFunction;
import tk.mybatis.mapper.common.Mapper;

public interface SysRoleFunctionMapper extends Mapper<SysRoleFunction> {
	// 根据角色编号取得权限ID
	List<Integer> selectFunctionByRoleId(@Param("roleId") Integer roleId);
}