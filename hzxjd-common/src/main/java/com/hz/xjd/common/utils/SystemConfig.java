package com.hz.xjd.common.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.Properties;

/**
 * 取得系统配置的信息
 */
public class SystemConfig {
	private static String classPath;
	private static String appAbsPath;
	private static boolean isWindows;
	private static Properties props = new Properties();
	private static String propsName = "hzxjd.properties";
	static {
		initialize();
	}
	/**
	 * 初始化
	 */
	public static void initialize() {
		String osType = System.getProperty("os.name");
		isWindows = (osType == null) || (osType.toUpperCase().indexOf("WINDOWS") > -1);
		if (isWindows) {
			classPath = SystemConfig.class.getResource("/").getPath();
			classPath = classPath.replace("file:", "");
			int pos = classPath.indexOf("/classes/");
			if (pos > -1) {
				classPath = classPath.substring(1, pos + 9);
			}
		} else {
			classPath = SystemConfig.class.getResource("").getPath();
			classPath = classPath.replace("file:", "");
			int pos = classPath.indexOf("/classes/");
			if (pos == -1) {
				pos = classPath.indexOf("/lib/");
				if (pos > -1) {
					classPath = classPath.substring(0, pos + 5);
				}
			} else {
				classPath = classPath.substring(0, pos + 9);
			}
		}
		classPath = classPath.replace("/lib/", "/classes/");
		String configPath = classPath;
		appAbsPath = classPath.replace("/WEB-INF/classes/", "");

		try {
			classPath = URLDecoder.decode(classPath, "UTF-8");
		} catch (Exception e) {
			System.out.println("系统配置的信息取得异常："+e.getMessage());
			e.printStackTrace();
		}
		loadProperties(configPath + propsName);
	}
	public static String getClassPath() {
		return classPath;
	}
	public static String getAppAbsPath() {
		return appAbsPath;
	}
	public static boolean isLinux() {
		return !isWindows;
	}
	public static String getProperty(String key, String defaultProperty) {
		return props.getProperty(key, defaultProperty);
	}
	public static String getProperty(String key) {
		return props.getProperty(key);
	}
	private static void loadProperties(String propertyFile) {
		InputStream ins = null;
		try {
			ins = new FileInputStream(propertyFile);
			props.load(ins);
			ins.close();
		} catch (Exception e) {
			System.out.println("Not found config file: " + classPath + ".");

		} finally {
			try {
				if (ins != null) {
					ins.close();
				}
			} catch (IOException localIOException) {
				//
			}
		}
	}

}


