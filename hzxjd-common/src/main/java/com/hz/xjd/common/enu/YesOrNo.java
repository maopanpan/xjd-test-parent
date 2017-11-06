package com.hz.xjd.common.enu;

import com.hz.xjd.common.utils.StringUtils;

public enum YesOrNo {
	yes("是"),
	no("否");

	public String descr;

	private YesOrNo(String descr) {
		this.descr = descr;
	}

	public static YesOrNo getYesOrNo(String arg) {
		if (StringUtils.isEmpty(arg)) {//参数为空，返回null
			return null;
		}
		try {
			return YesOrNo.valueOf(arg.trim());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
