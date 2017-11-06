/*
 * 文 件 名:  DecryptPropertyPlaceholderConfigurer.java
 *
 * 描    述:  <描述>
 * 修 改 人:  huangggang
 * 修改时间:  2015年07月03日
 */
package com.hz.xjd.app.utils;

import java.util.Properties;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import com.hz.xjd.common.web.PropertyConfigurer;


/**
 * 重写PropertyPlaceholderConfigurer的processProperties方法实现
 * <功能详细描述>
 *
 * @author  huanggang
 * @version  [版本号, 2015年07月03日]
 */
public class DecryptPropertyPlaceholderConfigurer extends PropertyConfigurer
{
    private static Properties properties;

    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactory, Properties props)
        throws BeansException
    {
        properties = props;
        super.processProperties(beanFactory, props);

    }

    public static Object getProperties(String key)
    {
        return properties.get(key);
    }

    /** <一句话功能简述>
     * <功能详细描述>
     * @param args
     * @see [类、类#方法、类#成员]
     */
    public static void main(String[] args)
    {
        String password = "gang0713.";
        System.out.println(new String(Base64.encodeBase64(password.getBytes())));
    }
}
