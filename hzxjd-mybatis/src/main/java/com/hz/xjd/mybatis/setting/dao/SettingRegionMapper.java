package com.hz.xjd.mybatis.setting.dao;

import com.hz.xjd.model.setting.entity.SettingRegion;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 获取区域信息
 */
public interface SettingRegionMapper extends Mapper<SettingRegion> {

    public List<Map<String, Object>> selectRegions(Map<String, Object> params);
}