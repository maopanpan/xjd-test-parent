package com.hz.xjd.mybatis.sys.dao;

import org.apache.ibatis.annotations.Param;

import com.hz.xjd.model.sys.entity.SysRole;
import tk.mybatis.mapper.common.Mapper;

public interface SysRoleMapper extends Mapper<SysRole> {
	/**
	 * 取得角色信息
	 * @param roleId
	 * @return
	 */
	SysRole selectByRoleId(@Param("roleId") Integer roleId);
}