package com.hz.xjd.app;

import java.util.HashMap;
import java.util.Map;

import com.hz.xjd.app.utils.DES3Util;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;

import com.alibaba.fastjson.JSON;

public class Test {
	
	private static final int TIMEOUT = 20000;
	private static final String DEFAULT_CHARSET = "UTF-8";
	private static org.apache.commons.httpclient.HttpClient client;
	private static final String PASSWORD_CRYPT_KEY = "2017/10/10xianjingdaijiayou!!!";


	
	private static synchronized org.apache.commons.httpclient.HttpClient getClient() {
		if (null == client) {
			client = new org.apache.commons.httpclient.HttpClient();
			client.getHttpConnectionManager().getParams().setConnectionTimeout(TIMEOUT);
			client.getHttpConnectionManager().getParams().setSoTimeout(TIMEOUT);
		}
		return client;
	}

	
	public static String sendHttpJson(String url, String json, Integer timeout) {
		PostMethod postMethod = null;
		try {
			// 返回的数据
			String responseMsg = "";
			org.apache.commons.httpclient.HttpClient client = getClient();
			if (timeout != null) {
				client.getHttpConnectionManager().getParams().setConnectionTimeout(timeout);
				client.getHttpConnectionManager().getParams().setSoTimeout(timeout);
			}
			// 设置字符编码
			client.getParams().setContentCharset(DEFAULT_CHARSET);
			// 构造PostMethod的实例
			postMethod = new PostMethod(url);
			RequestEntity entity = new StringRequestEntity("321111111111111");
			postMethod.setRequestEntity(entity);
			//postMethod.addRequestHeader("Authorization", sign);
			postMethod.addRequestHeader("Accept", "application/json");
			postMethod.addRequestHeader("Content-Type", "application/json;charset=UTF-8");
			// 参数值加入postMethod
			postMethod.setRequestBody(json);
			// 执行postMethod,调用http接口
			client.executeMethod(postMethod);// 200 ok
			// 读取内容
			responseMsg = postMethod.getResponseBodyAsString().trim();
			// 返回数据
			return responseMsg;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			// 释放连接
			if (postMethod != null) {
				postMethod.releaseConnection();
			}
		}
	}
	
	

	
	public static void main(String[] args) {
		//accountName=maopanpan&password=123456&opSource=ad&imei=3123123123&version=v1.0
		Map<String, Object> param = new HashMap<>();
		param.put("accountName", "15011479990");
		param.put("password", "123456");
		param.put("opSource", "ad");
		param.put("imei", "3123123123");
		param.put("version", "v1.0");

		String requestJson = JSON.toJSONString(param);
		String result = sendHttpJson("http://localhost:8080/app/user/v1/userLogin", DES3Util.encryptMode(requestJson, PASSWORD_CRYPT_KEY), 1000*20);
		System.out.println(result);
	}

}
