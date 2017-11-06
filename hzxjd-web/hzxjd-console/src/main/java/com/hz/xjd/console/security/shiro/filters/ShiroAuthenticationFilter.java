package com.hz.xjd.console.security.shiro.filters;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.web.filter.authc.PassThruAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.hz.xjd.common.constants.ResponseCode;
import com.hz.xjd.common.model.Result;
import com.hz.xjd.common.utils.SystemConfig;

public class ShiroAuthenticationFilter extends PassThruAuthenticationFilter {
	private static Logger logger = LoggerFactory.getLogger(ShiroAuthenticationFilter.class);

	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		logger.info("onAccessDenied start");
		if (isLoginRequest(request, response)) {
			return true;
		} else {
			saveRequest(request);
			if (((HttpServletRequest) request).getHeader("Accept").contains("application/json")) {
				response.setCharacterEncoding("UTF-8");
				response.setContentType("application/json;charset=UTF-8");
				Result result = new Result(ResponseCode.UNAUTHENTICATED.getCode(), ResponseCode.UNAUTHENTICATED.getMsg());
				response.getWriter().append(new Gson().toJson(result));
				response.getWriter().flush();
				response.getWriter().close();
			} else {
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/html;charset=UTF-8");
				((HttpServletResponse) response).sendRedirect(SystemConfig.getProperty("app.root"));
			}
		}
		return false;
	}

}
