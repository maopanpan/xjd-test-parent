
package com.hz.xjd.common.enu;

/**
*
* 系统配置类型枚举
*
*/
public enum PropertyType {
	third_interface("三方接口配置"),
	basic_settings("系统基本配置"),
	constant_settings("系统常量配置"),
	variable_settings("系统变量配置"),
	third_account("三方账户配置");

	public String descr;

	private PropertyType(String descr) {
		this.descr = descr;
	}
}
