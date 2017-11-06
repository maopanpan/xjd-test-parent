package com.hz.xjd.app.setting;

import com.alibaba.fastjson.JSON;
import com.hz.xjd.app.BaseTest;
import com.hz.xjd.biz.setting.service.SettingTemplateService;
import com.hz.xjd.model.setting.entity.SettingTemplate;
import com.hz.xjd.model.sys.entity.SysUser;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by maopanpan on 2017/10/31.
 */
public class SettingTemplateTest extends BaseTest {

    private Logger logger = LoggerFactory.getLogger(SettingTemplateTest.class);

    @Autowired
    private SettingTemplateService settingTemplateService;

    @Value("${jdbc.driverClass}")
    private String driverClass;


    @Test
    public void selectSettingTemplate() {
        Map<String, Object> params = new HashMap<>();
        params.put("templateType", "msg");
        params.put("templateNo", "sms1000002");
//        SettingTemplate settingTemplate = settingTemplateService.querySettingTemplateById(1);
//        Assert.assertNotNull(settingTemplate);
//        logger.info("读取数据为："+ JSON.toJSONString(settingTemplate));
        SettingTemplate settings = settingTemplateService.selectSettingByTemplateNo("msg", "sms1000002");
        Assert.assertNotNull(settings);
        logger.info("读取数据为：" + JSON.toJSONString(settings));
//        SysUser sysUser = settingTemplateService.selectSysUserByName("张三");
//        Assert.assertNotNull(sysUser);
//        logger.info("读取数据为："+ JSON.toJSONString(sysUser));

        SettingTemplate setting1 = settingTemplateService.selectSettingByTemplateNo("msg", "sms1000002");
        logger.info("读取数据为：" + JSON.toJSONString(setting1));
    }
}
