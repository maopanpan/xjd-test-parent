package com.hz.xjd.common.model;

import java.io.Serializable;

import com.hz.xjd.common.constants.ResponseCode;

public class Result implements Serializable {

	private static final long serialVersionUID = 6500729515912378356L;

	/**
	 * 返回代码
	 */
	public String code;

	/**
	 * 错误信息
	 */
	public String msg;

	/**
	 * 返回数据
	 */
	public Object data;

	/**
	 * 成功构造方法<默认构造函数>
	 */
	public Result(Object data){
		this.code = ResponseCode.SUCCESS.getCode();
		this.data = data;
		this.msg = ResponseCode.SUCCESS.getMsg();
	}
	/**
	 * 构造方法
	 */
	public Result(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	/**
	 * 构造方法
	 */
	public Result(String code, String msg, Object data) {
		this.code = code;
		this.data = data;
		this.msg = msg;
	}

	public Result setCode(String code) {
		this.code = code;
		return this;
	}

	public Result setMsg(String msg) {
		this.msg = msg;
		return this;
	}

	public Result setData(Object data) {
		this.data = data;
		return this;
	}

	/**
	 * 返回执行结果代码
	 * @return 结果代码
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 返回错误消息
	 * @return 错误消息
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * 返回执行结果数据
	 * @return 结果数据，具体类型要看接口定义
	 */
	public Object getData() {
		return data;
	}

	/**
	 * 接口执行是否成功
	 * @return 成功返回true，失败返回false
	 */
	public boolean isSuccess() {
		return ResponseCode.SUCCESS.getCode().equals(code);
	}


	@Override
	public String toString() {
		return "Result [code=" + code + ", msg=" + msg + "]";
	}

	public static Result result(String msg) {
		return result(null,msg,null);
	}

	public static Result result(String code, String msg) {
		return result(code,msg,null);
	}

	public static Result result(String code, String msg, Object data) {
		Result result = new Result(code, msg, data);
		return result;
	}

	public static Result error() {
		return new Result(ResponseCode.FAILURE.getCode(), ResponseCode.FAILURE.getMsg());
	}
	public static Result error(String msg) {
		return new Result(ResponseCode.FAILURE.getCode(), msg);
	}
}
