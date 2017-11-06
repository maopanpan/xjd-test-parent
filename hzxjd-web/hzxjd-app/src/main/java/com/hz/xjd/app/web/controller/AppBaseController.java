/*
 * 文 件 名:  BaseController.java
 * 版    权:  © 2013 dimeng. All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  huanggang
 * 修改时间:  2013-2-25
 */
package com.hz.xjd.app.web.controller;

import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;

import com.hz.xjd.common.constants.IResultsCode;
import com.hz.xjd.common.model.BaseDataResp;
import org.springframework.http.HttpEntity;

import com.hz.xjd.app.constants.DigitalAndStringConstant;
import com.hz.xjd.app.exception.ServicesException;
import com.hz.xjd.common.utils.CookieUtil;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

/**
 * Controller基类
 * <功能详细描述>
 *
 * @author  huanggang
 * @version  [版本号, 2012-12-3]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class AppBaseController
{

	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected HttpSession session;

    @Resource(name = "loginCache")
    protected Cache loginCache;

	/**
	 * 保存请求信息，响应信息，session
	 * @param request
	 * @param response
	 */
	public void setReqAndRes(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.session = request.getSession();
	}

	/**
	 * 从session中取得指定用户信息
	 * @param attrName
	 * @param classType
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> T getAttrFromSession(String attrName, Class<T> classType) {
		return (T) this.session.getAttribute(attrName);
	}
	/**
	 * 取得cookie的value值
	 * @param res
	 * @param name
	 * @return
	 */
	public String getCookieValue(HttpServletResponse res, String name) {
		return new CookieUtil(this.request, this.response).getCookieValue(name);
	}

	/**
	 * 设置cookie
	 * @param name
	 * @param value
	 */
	public void setCookie(String name, String value) {
		new CookieUtil(this.request, this.response).addCookie(name, value);
	}

	/**
	 * 设置cookie
	 * @param name
	 * @param value
	 * @param domain
	 * @param path
	 * @param maxAge
	 */
	public void setCookie(String name, String value, String domain, String path, int maxAge) {
		new CookieUtil(this.request, this.response).addCookie(name, value, domain, path, maxAge);
	}

	/**
	 * 删除cookie
	 * @param name
	 */
	public void removeCookie(String name) {
		new CookieUtil(this.request, this.response).removeCookie(name);
	}

	/**
	 * 删除cookie
	 * @param name
	 * @param path
	 */
	public void removeCookie(String name, String path) {
		new CookieUtil(this.request, this.response).removeCookie(name, path);
	}

    /**
     * @return 返回 loginCache
     */
    public Cache getLoginCache()
    {
        return loginCache;
    }

    /**
     * 对loginCache进行赋值
     * @param loginCache loginCache
     */
    public void setLoginCache(Cache loginCache)
    {
        this.loginCache = loginCache;
    }

    /**
     * 参数验证公用方法
     * <功能详细描述>
     * @param obj 传入要验证的对象
     * @return
     * @see [类、类#方法、类#成员]
     */
    protected <T> Set<ConstraintViolation<T>> validator(T obj)
    {
        return Validation.buildDefaultValidatorFactory().getValidator().validate(obj);
    }

    /**
     * 参数验证公用方法
     * <功能详细描述>
     * @param httpEntity 传入要验证的对象
     * @return
     * @see [类、类#方法、类#成员]
     */
    protected <T> BaseDataResp validator(HttpEntity<T> httpEntity)
    {
        Set<ConstraintViolation<T>> violations =
            Validation.buildDefaultValidatorFactory().getValidator().validate(httpEntity.getBody());
        BaseDataResp baseResp = new BaseDataResp();
        //如果size为0，验证通过，否则不通过
        if (DigitalAndStringConstant.DigitalConstant.ZERO < violations.size())
        {
            baseResp.setCode(IResultsCode.ERROR_PARAMETER);
            return baseResp;
        }
        baseResp.setCode(IResultsCode.SUCCESS);
        return baseResp;
    }

    /**
     * 参数验证公用方法
     * <功能详细描述>
     * @param obj 传入要验证的对象
     * @param classz 参数验证时，如果需要分组验证时，要传对应的分组类名
     * @return
     * @see [类、类#方法、类#成员]
     */
    protected <T> Set<ConstraintViolation<T>> validator(T obj, @SuppressWarnings("rawtypes") Class classz)
    {
        return Validation.buildDefaultValidatorFactory().getValidator().validate(obj, classz);
    }

    /**
     * 获取访问IP
     * <功能详细描述>
     * @return
     */
    protected String getRemoteIp(HttpServletRequest request)
    {
        String ip = request.getHeader("X-Forwarded-For");
        if (null == ip)
        {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * 根据token获取用户ID
     * <功能详细描述>
     * @return
     */
    protected Integer getUserIdByAuthorization(HttpServletRequest request)
    {
        try
        {
            Element element = loginCache.get(request.getHeader("Authorization"));
            if (null == element)
            {
                throw new ServicesException(IResultsCode.USER_ERROR_DIS_ACCREDIT);
                // return 0;
            }
            return (Integer)element.getObjectValue();
        }
        catch (Exception e)
        {
            return null;
        }

    }

    /**
     * 根据token获取用户ID
     * <功能详细描述>
     * @return
     */
    protected void removeUserIdByAuthorization(HttpServletRequest request)
    {
        try
        {
            loginCache.remove(request.getHeader("Authorization"));
        }
        catch (Exception e)
        {
        }
    }
}
