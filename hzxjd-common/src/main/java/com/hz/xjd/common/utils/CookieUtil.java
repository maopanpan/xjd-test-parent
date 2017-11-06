package com.hz.xjd.common.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * cookie工具类
 *
 */
public class CookieUtil {
	HttpServletRequest request;
	HttpServletResponse response;

	public CookieUtil(HttpServletRequest req, HttpServletResponse res) {
		this.request = req;
		this.response = res;
	}
	/**
	 * 根据名称取得cookie的value值
	 * @param name
	 * @return
	 */
	public String getCookieValue(String name) {
		Cookie[] cookies = this.request.getCookies();
		if ((cookies == null) || (cookies.length == 0)){//没有cookie
			return null;
		}
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals(name)){//cookie中是否存在name
				return cookie.getValue();
			}
		}
		return null;
	}
	/**
	 * 根据名称取得cookie
	 * @param name
	 * @return
	 */
	public Cookie getCookie(String name) {
		Cookie[] cookies = this.request.getCookies();
		if ((cookies == null) || (cookies.length == 0)){
			return null;
		}
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals(name)) {
				return cookie;
			}
		}
		return null;
	}

	/**
	 * 增加cookie
	 * @param name
	 * @param value
	 */
	public void addCookie(String name, String value) {
		addCookie(name, value, null, null, 0);
	}

	/**
	 * 增加cookie
	 * @param name
	 * @param value
	 * @param domain
	 * @param path
	 * @param maxAge
	 */
	public void addCookie(String name, String value, String domain, String path, int maxAge) {
		Cookie cookie = new Cookie(name, value);
		if (domain != null) {
			cookie.setDomain(domain);
		}
		if (path != null) {
			cookie.setPath(path);
		}
		if (maxAge > 0) {
			cookie.setMaxAge(maxAge);
		}
		this.response.addCookie(cookie);
	}

	/**
	 * 删除cookie
	 * @param name
	 */
	public void removeCookie(String name) {
		Cookie cookie = new Cookie(name, "");
		cookie.setMaxAge(0);
		this.response.addCookie(cookie);
	}

	/**
	 * 删除cookie
	 * @param name
	 * @param path
	 */
	public void removeCookie(String name, String path) {
		Cookie cookie = new Cookie(name, "");
		if (path != null) {
			cookie.setPath(path);
		}
		cookie.setMaxAge(0);
		this.response.addCookie(cookie);
	}

	/**
	 * 设置 Cookie（生成时间为1天）
	 * @param name 名称
	 * @param value 值
	 */
	public static void setCookie(HttpServletResponse response, String name, String value) {
		setCookie(response, name, value, 60*60*24);
	}

	/**
	 * 设置 Cookie
	 * @param name 名称
	 * @param value 值
	 * @param maxAge 生存时间（单位秒）
	 * @param uri 路径
	 */
	public static void setCookie(HttpServletResponse response, String name, String value, String path) {
		setCookie(response, name, value, path, 60*60*24);
	}

	/**
	 * 设置 Cookie
	 * @param name 名称
	 * @param value 值
	 * @param maxAge 生存时间（单位秒）
	 * @param uri 路径
	 */
	public static void setCookie(HttpServletResponse response, String name, String value, int maxAge) {
		setCookie(response, name, value, "/", maxAge);
	}

	/**
	 * 设置 Cookie
	 * @param name 名称
	 * @param value 值
	 * @param maxAge 生存时间（单位秒）
	 * @param uri 路径
	 */
	public static void setCookie(HttpServletResponse response, String name, String value, String path, int maxAge) {
		Cookie cookie = new Cookie(name, null);
		cookie.setPath(path);
		cookie.setMaxAge(maxAge);
		try {
			cookie.setValue(URLEncoder.encode(value, "utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		response.addCookie(cookie);
	}

	/**
	 * 获得指定Cookie的值
	 * @param name 名称
	 * @return 值
	 */
	public static String getCookie(HttpServletRequest request, String name) {
		return getCookie(request, null, name, false);
	}
	/**
	 * 获得指定Cookie的值，并删除。
	 * @param name 名称
	 * @return 值
	 */
	public static String getCookie(HttpServletRequest request, HttpServletResponse response, String name) {
		return getCookie(request, response, name, true);
	}
	/**
	 * 获得指定Cookie的值
	 * @param request 请求对象
	 * @param response 响应对象
	 * @param name 名字
	 * @param isRemove 是否移除
	 * @return 值
	 */
	public static String getCookie(HttpServletRequest request, HttpServletResponse response, String name, boolean isRemove) {
		String value = null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(name)) {
					try {
						value = URLDecoder.decode(cookie.getValue(), "utf-8");
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					if (isRemove) {
						cookie.setMaxAge(0);
						response.addCookie(cookie);
					}
				}
			}
		}
		return value;
	}


}
