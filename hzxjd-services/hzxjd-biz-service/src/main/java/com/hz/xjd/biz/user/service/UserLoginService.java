package com.hz.xjd.biz.user.service;

import com.hz.xjd.common.model.LoginBean;
import com.hz.xjd.common.model.Result;

/**
 *
 * 用户登录接口
 *
 */
public interface UserLoginService {
	/**
	 * 支持手机登陆
	 * @param LoginBean{accountName:'',mobile:'',userNo:'',Password:'',ip:''}<br>
	 * @return
	 */
	public Result checkIn(LoginBean loginBean);
}
