package com.hz.xjd.app.web.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.hz.xjd.app.utils.AppContextManager;

public class SystemInitializationListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent event) {
		AppContextManager.instance.setServletContext(event.getServletContext());
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}

}
