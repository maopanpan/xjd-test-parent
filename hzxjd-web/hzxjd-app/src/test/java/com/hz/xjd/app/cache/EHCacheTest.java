package com.hz.xjd.app.cache;

import com.hz.xjd.app.BaseTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

/**
 * Created by maopanpan on 2017/10/31.
 *
 * 本地缓存测试
 */
public class EHCacheTest extends BaseTest {

    private Logger logger = LoggerFactory.getLogger(EHCacheTest.class);

    @Autowired
    private CacheManager ehCacheManager;

    @Test
    public void test() {
        Cache cache = ehCacheManager.getCache("login-Cache");
        cache.put("name", "张三");

        logger.info("@@@@@@@@@@读取缓存数据 @@@@@@@@@@");
        logger.info(cache.get("name", String.class));
    }
}
