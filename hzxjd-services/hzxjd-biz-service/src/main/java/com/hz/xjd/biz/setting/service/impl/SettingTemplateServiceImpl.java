package com.hz.xjd.biz.setting.service.impl;

import com.hz.xjd.biz.base.service.BaseService;
import com.hz.xjd.biz.setting.service.SettingTemplateService;
import com.hz.xjd.model.setting.entity.SettingTemplate;
import com.hz.xjd.model.sys.entity.SysUser;
import com.hz.xjd.mybatis.setting.dao.SettingTemplateMapper;
import com.hz.xjd.mybatis.sys.dao.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by maopanpan on 2017/10/31.
 */
@Service
public class SettingTemplateServiceImpl extends BaseService<SettingTemplateMapper, SettingTemplate> implements SettingTemplateService {

    @Autowired
    private SettingTemplateMapper settingTemplateMapper;


    @Override
    @Cacheable(value = "login-Cache", key = "'smsTemplate' + #templateNo")
    public SettingTemplate selectSettingByTemplateNo(String templateType, String templateNo) {
        SettingTemplate settingTemplate = new SettingTemplate();
        settingTemplate.setTemplateType(templateType);
        settingTemplate.setTemplateNo(templateNo);
        settingTemplate.setDeleteFlg(0);
        return settingTemplateMapper.selectOne(settingTemplate);
    }
}
