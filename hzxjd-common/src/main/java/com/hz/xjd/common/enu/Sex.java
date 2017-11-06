package com.hz.xjd.common.enu;
/**
*
* 性别枚举
*
*/
public enum Sex {
	female("女"),
	male("男"),
	unknown("未知");

	public String descr;

	private Sex(String descr) {
		this.descr = descr;
	}
}
