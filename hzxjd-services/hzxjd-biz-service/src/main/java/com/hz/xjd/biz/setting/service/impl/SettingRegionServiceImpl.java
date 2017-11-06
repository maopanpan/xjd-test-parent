package com.hz.xjd.biz.setting.service.impl;

import com.hz.xjd.biz.setting.service.SettingRegionService;
import com.hz.xjd.model.setting.entity.SettingRegion;
import com.hz.xjd.mybatis.setting.dao.SettingRegionMapper;
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
public class SettingRegionServiceImpl implements SettingRegionService {

    @Autowired
    private SettingRegionMapper settingRegionMapper;

    @Override
    @Cacheable(value = "login-Cache", key = "'regionTemplate' + #pcode")
    public List<Map<String, Object>> selectRegions(Integer pcode) {
        Map<String, Object> params = new HashMap<>();
        params.put("pcode", pcode);
        List<Map<String, Object>> regions = settingRegionMapper.selectRegions(params);
        return regions;
    }

}
