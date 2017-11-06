package com.hz.xjd.app.setting;

import com.alibaba.fastjson.JSON;
import com.hz.xjd.app.BaseTest;
import com.hz.xjd.biz.setting.service.SettingRegionService;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by maopanpan on 2017/10/31.
 */
public class SettingRegionTest extends BaseTest {

    private Logger logger = LoggerFactory.getLogger(SettingRegionTest.class);

    @Autowired
    private SettingRegionService settingRegionService;

    @Test
    public void test() {
        Map<String, Object> params = new HashMap<>();
        params.put("pcode", 0);
        List<Map<String, Object>> regions = settingRegionService.selectRegions(0);
        Assert.assertNotNull(regions);
        logger.info("读取数据为：" + JSON.toJSONString(regions));

        if(regions.size() > 0) {
            for (Map<String, Object> res: regions) {
                Integer pcode = (Integer) res.get("code");
                regions = settingRegionService.selectRegions(pcode);
                logger.info("读取数据为：" + JSON.toJSONString(regions));
            }
        }


//        List<Map<String, Object>> regions1 = settingRegionService.selectRegions(0);
//        Assert.assertNotNull(regions1);
//        logger.info("读取数据为：" + JSON.toJSONString(regions1));
//
//        if(regions1.size() > 0) {
//            for (Map<String, Object> res: regions1) {
//                Integer pcode = (Integer) res.get("code");
//                regions1 = settingRegionService.selectRegions(pcode);
//                logger.info("读取数据为：" + JSON.toJSONString(regions1));
//            }
//        }
    }
}
