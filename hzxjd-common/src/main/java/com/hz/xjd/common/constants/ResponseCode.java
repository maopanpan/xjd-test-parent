package com.hz.xjd.common.constants;

/**
 *
 * 响应code的枚举类
 *
 */
public enum ResponseCode {
	SUCCESS("0000", "成功"),
	//连接响应
	FAILURE("1000", "系统错误"),
	REPEAT("1001", "重复调用"),
	PARAM_ERR("1002", "参数错误"),
	STATUS_ERR("1003", "无效状态"),
	//2~8开头的为业务响应返回
	UNKNOWN("2000", "账户不存在"),
	FORBIDDEN("2001", "账户已禁用"),
	INCORRECT("2002", "密码错误"),
	VERIFY_ERR("2003", "验证码错误,请重新刷新并输入验证码!"),
	UNAUTHORIZED("2004", "无操作权限"),
	UNAUTHENTICATED("2005", "用户未登录"),
	CERT_NOT_ALL("2006", "安全认证不全"),
	MISSING_PARAMETER("2007", "缺少参数"),
	PARAM_FORMAT_ERROR("2008", "参数格式错误"),
	FORBIDDEN_IP("2009", "非法请求"),
	//9开头为系统响应
	SYS_ERROR("9000", "系统繁忙，请稍后重试!");

	private String code;
	private String msg;

	ResponseCode(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String toString() {
		return "ResponseCode{code:[" + code + "], msg:[" + msg + "]}";
	}
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
