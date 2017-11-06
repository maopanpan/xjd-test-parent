package com.hz.xjd.app.redis;

import com.hz.xjd.app.BaseTest;
import com.hz.xjd.manager.RedisManager;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: maopanpan
 * @Description: redis连通测试
 * @Date: 2017/11/01.
 **/
public class RedisTest extends BaseTest {

    @Autowired
    private RedisManager redisManager;

    @Test
    public void test() {
        redisManager.incr(2, "zhangsan");
    }
}
