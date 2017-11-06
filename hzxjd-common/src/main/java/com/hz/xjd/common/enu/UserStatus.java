package com.hz.xjd.common.enu;

/**
*
* 用户状态枚举
*
*/
public enum UserStatus {
	enable("启用"),
	disable("禁用");

	public String descr;

	private UserStatus(String descr) {
		this.descr = descr;
	}
}
