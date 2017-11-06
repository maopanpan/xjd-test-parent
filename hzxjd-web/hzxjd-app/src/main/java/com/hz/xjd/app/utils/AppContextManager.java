package com.hz.xjd.app.utils;

import javax.servlet.ServletContext;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.hz.xjd.common.utils.SystemConfig;
/**
 * 加载Spring上下文环境
 */
public class AppContextManager implements ApplicationContextAware {
	//实例化
	public static AppContextManager instance = new AppContextManager();

	private ServletContext servletContext;
	private ApplicationContext appContext;

	public static AppContextManager getInstance() {
		return instance;
	}
	/**
	 * 加载Spring上下文环境
	 */
	public void loadApplicationContext() {
		if (this.appContext != null) {
			return;
		}
		try {
			if (this.servletContext != null) {
				this.appContext = WebApplicationContextUtils.getWebApplicationContext(this.servletContext);
				return;
			}
			System.out.println("手动加载Spring配置文件>>>>>>>>>>>");
			String path = SystemConfig.getClassPath();
			if (SystemConfig.isLinux()) {
				path = "/" + path;
			}
			String[] configFiles = { path + "spring-context.xml" };
			this.appContext = new FileSystemXmlApplicationContext(configFiles);
		} catch (Exception e) {
			System.out.println("手动加载Spring配置文件出错：" + e);
			e.printStackTrace();
		}
	}
	/**
	 * 根据bean名称，取得bean对象
	 * @param beanName
	 * @return
	 */
	public static Object getBean(String beanName) {
		return instance.getAppContext().getBean(beanName);
	}
	/**
	 * 取得实体对象
	 * @param beanClass
	 * @return
	 */
	public static <T> T getBean(Class<T> beanClass) {
		return instance.getAppContext().getBean(beanClass);
	}

	public ApplicationContext getAppContext() {
		if (this.appContext == null) {
			loadApplicationContext();
		}
		return this.appContext;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.appContext = applicationContext;
	}

	public ServletContext getServletContext() {
		return this.servletContext;
	}
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

}
