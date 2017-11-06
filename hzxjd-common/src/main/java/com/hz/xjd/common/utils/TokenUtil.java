package com.hz.xjd.common.utils;
import javax.servlet.http.HttpServletRequest;


public class TokenUtil {

	/**
	 * 校验token
	 * @param member
	 * @return
	 */
	public static boolean validateToken(HttpServletRequest request){
		String token = request.getParameter("token");
		if(StringUtils.isEmpty(token)){
			return false;
		}
		String sessionToken = (String)request.getSession().getAttribute("token");
		request.getSession().removeAttribute("token"); //移除token,一个token只用一次
		if(sessionToken == null){
			return false;
		}
		return token.equals(sessionToken);
	}

	/**
	 * 产生token，并且设置在http header,session中
	 */
	public static String setToken(HttpServletRequest request){
		String token = java.util.UUID.randomUUID().toString().replace("-", "");
		request.getSession().setAttribute("token", token);
		//有返回值，是为了解决ajax操作错误影响二次提交
		return token;
	}


}
