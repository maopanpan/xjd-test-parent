package com.hz.xjd.common.web;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import com.hz.xjd.common.utils.EncryptUtil;
import com.hz.xjd.common.utils.FileUtil;
import com.hz.xjd.common.utils.SystemConfig;

/**
 * 读取配置文件
 * @author hujunlong
 *
 */
public class PropertyConfigurer extends PropertyPlaceholderConfigurer {
	private static Object lock = new Object();
	public String convertProperty(String propertyName, String propertyValue) {
		if (propertyName.startsWith("jdbc.")) {//数据库配置信息进行加解密处理
			if (propertyValue.length() > 50) {
				synchronized (lock) {
					if ((propertyName.equals("jdbc.url")) && (propertyValue.startsWith("jdbc:"))) {
						encryptConfigFile(propertyName, propertyValue);
					} else {
						return EncryptUtil.decode(propertyValue)[0];
					}
				}
			}
			encryptConfigFile(propertyName, propertyValue);
		}

		return propertyValue;
	}

	private void encryptConfigFile(String key, String value) {
		System.out.println("第一次启动，加密密码文件！");
		String encodeValue = EncryptUtil.encode(value);
		String filepath = SystemConfig.getClassPath() + SystemConfig.getProperty("jdbcFile");
		String content = FileUtil.readFromFile(filepath);
		content = content.replace(key + "=" + value, key + "=" + encodeValue);
		FileUtil.writeToFile(content, filepath);
	}
}
