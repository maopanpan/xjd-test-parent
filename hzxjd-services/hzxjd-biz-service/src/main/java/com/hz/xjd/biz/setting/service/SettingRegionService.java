package com.hz.xjd.biz.setting.service;

import com.hz.xjd.model.setting.entity.SettingRegion;

import java.util.List;
import java.util.Map;

/**
 * Created by maopanpan on 2017/10/31.
 */
public interface SettingRegionService {

    List<Map<String, Object>> selectRegions(Integer pcode);
}