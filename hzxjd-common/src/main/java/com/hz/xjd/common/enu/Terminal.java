package com.hz.xjd.common.enu;

/**
 *
 * 终端枚举
 *
 */

public enum Terminal {
	pc("前端"),
	ad("安卓"),
	ios("苹果"),
	wx("微信"),
	other("其他");

	public String descr;

	private Terminal(String descr){
		this.descr = descr;
	}

}
