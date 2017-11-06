package com.hz.xjd.common.model;

import java.io.Serializable;

/*
 * 登陆bean
 */
public class LoginBean implements Serializable {

	private static final long serialVersionUID = -4079015764913821619L;
	/**
	 * 账户名称(手机号)
	 */
	protected String accountName;
	/**
	 * 登录密码
	 */
	protected String password;
	/**
	 * 短信验证码登录
	 */
	protected String verifyCode;

	/**
	 * 用户内部编号
	 */
	protected String userNo;
	/**
	 * IP地址
	 */
	protected String ip;

	/**
	 * @return the accountName
	 */
	public String getAccountName() {
		return accountName;
	}
	/**
	 * @param accountName the accountName to set
	 */
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the verifyCode
	 */
	public String getVerifyCode() {
		return verifyCode;
	}
	/**
	 * @param verifyCode the verifyCode to set
	 */
	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}
	/**
	 * @return the userNo
	 */
	public String getUserNo() {
		return userNo;
	}
	/**
	 * @param userNo the userNo to set
	 */
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	/**
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}
	/**
	 * @param ip the ip to set
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	@Override
	public String toString() {
		return "LoginBean [accountName=" + accountName
				+ ", password=" + password
				+ ", userNo=" + userNo
				+ ", ip=" + ip + "]";
	}

}
