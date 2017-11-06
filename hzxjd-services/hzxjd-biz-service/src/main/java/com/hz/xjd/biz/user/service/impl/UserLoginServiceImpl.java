package com.hz.xjd.biz.user.service.impl;


import java.sql.Timestamp;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hz.xjd.biz.user.service.UserLoginService;
import com.hz.xjd.common.constants.Constants;
import com.hz.xjd.common.constants.ResponseCode;
import com.hz.xjd.common.model.LoginBean;
import com.hz.xjd.common.model.Result;
import com.hz.xjd.common.utils.EncryptUtil;
import com.hz.xjd.common.utils.StringUtils;
import com.hz.xjd.model.log.entity.LogUserLogin;
import com.hz.xjd.model.user.entity.UserMobile;
import com.hz.xjd.mybatis.log.dao.LogUserLoginMapper;
import com.hz.xjd.mybatis.user.dao.UserMobileMapper;

/**
 *
 * 用户登录接口
 *
 */
@Service
public class UserLoginServiceImpl implements UserLoginService {

	protected Logger logger = LoggerFactory.getLogger(UserLoginServiceImpl.class);

	@Autowired
	private UserMobileMapper mobileDao;
	@Autowired
	private LogUserLoginMapper logUserLoginDao;


	@Override
	public Result checkIn(LoginBean loginBean) {
		logger.info("登录接口开始：参数："+loginBean.toString());
		// 返回参数
		Result result = null;
		String accountName = loginBean.getAccountName();
		String Password = loginBean.getPassword();

		try {
			//先判断登录账号(手机号)和密码是否为null
			if(!StringUtils.isEmpty(accountName) && !StringUtils.isEmpty(Password)){
				result = checkAccountName(loginBean);
			} else {
				logger.error(accountName+"--登录接口结束：返回：参数错误");
				return new Result(ResponseCode.PARAM_ERR.getCode(), "参数错误", accountName);
			}
			logger.info(accountName+"--登录接口结束。");
		} catch (Exception e) {
			logger.error(accountName+"--登录接口结束：返回：系统错误" ,e);
			return new Result(ResponseCode.FAILURE.getCode(), "系统错误", accountName);
		}
		logger.info("登录接口,result参数："+result.toString());
		logger.info("登录接口结束.");
		return result;
	}

	/**
	 * 判断accountName是否是手机 <br>
	 * 为数字时为手机号<br>
	 * @param loginBean
	 * @return
	 * @throws Exception
	 */
	private Result checkAccountName(LoginBean loginBean) throws Exception{
		Result result = null;
		UserMobile uMobile = null;
		String accountName = loginBean.getAccountName();
		if (StringUtils.isMobile(accountName)) {
			UserMobile pMobile = new UserMobile();
			pMobile.setMobile(accountName);
			pMobile.setDeleteFlg(Constants.INT_ZERO);
			uMobile = mobileDao.selectOne(pMobile);
		} else {//非手机登录时，异常
			return new Result(ResponseCode.UNKNOWN.getCode(), ResponseCode.UNKNOWN.getMsg(), accountName);
		}
		if(uMobile != null) {
			LogUserLogin logUserLogin = new LogUserLogin();

			logUserLogin.setMobile(uMobile.getMobile());
			logUserLogin.setUserNo(uMobile.getUserNo());
			logUserLogin.setLoginTime(new Timestamp(new Date().getTime()));
			logUserLogin.setIp(loginBean.getIp());
			//短信验证码为空，且登录密码非空时，认为是密码登录
			String verifyCode = loginBean.getVerifyCode();
			String password = loginBean.getPassword();
			if (StringUtils.isEmpty(verifyCode) && StringUtils.isNotEmpty(accountName)) {
				// 密码登录时，校验密码
				if(EncryptUtil.md5(password).equals(uMobile.getPassword())){
					logUserLogin.setSuccess(Constants.YES);
					logUserLoginDao.insert(logUserLogin);
					//更新最后的登录时间
					UserMobile tMobile = new UserMobile();
					tMobile.setId(uMobile.getId());
					tMobile.setLastLogintime(new Timestamp(new Date().getTime()));
					mobileDao.updateByPrimaryKeySelective(tMobile);

					result = new Result(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMsg(), tMobile);
				} else {
					logUserLogin.setSuccess(Constants.NO);
					logUserLogin.setFailCuase(Constants.USER_LOGIN_ERRORNAME);
					logUserLoginDao.insert(logUserLogin);
					result = new Result(ResponseCode.INCORRECT.getCode(), ResponseCode.INCORRECT.getMsg(), accountName);
				}
			} else {//短信验证码登录
				// TODO:短信验证码登录暂未实现
				result = new Result(ResponseCode.VERIFY_ERR.getCode(), "短信验证码登录暂未实现", accountName);
			}
		} else {
			result = new Result(ResponseCode.UNKNOWN.getCode(), ResponseCode.UNKNOWN.getMsg(), accountName);
		}
		return result;
	}

}
