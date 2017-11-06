package com.hz.xjd.mybatis.setting.dao;

import com.hz.xjd.model.setting.entity.SettingTemplate;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 获取系统模板配置
 */
public interface SettingTemplateMapper extends Mapper<SettingTemplate> {

    /**
     * 获取系统配置模板
     *
     * @return
     */
    SettingTemplate selectSettingByTemplateNo(Map<String, Object> params);
}