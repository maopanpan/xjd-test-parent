package com.hz.xjd.biz.setting.service;

import com.hz.xjd.model.setting.entity.SettingTemplate;
import com.hz.xjd.model.sys.entity.SysUser;

import java.util.List;
import java.util.Map;

/**
 * Created by maopanpan on 2017/10/31.
 *
 * 获取系统配置模板
 */
public interface SettingTemplateService {

    /**
     * 获取系统配置模板
     *
     * @return
     */
    SettingTemplate selectSettingByTemplateNo(String templateType, String templateNo);

}