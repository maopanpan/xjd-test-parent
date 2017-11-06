package com.hz.xjd.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by maopanpan on 2017/11/01.
 */
@Component
public class RedisManager {

    @Autowired
    private JedisPool j;


    public void set(int index, String key, long liveTime, Object value) {
        Jedis redis = j.getResource();
        redis.select(index);
        redis.setex(key, (int) liveTime, String.valueOf(value));
        redis.close();
    }

    public void incr(int index, String key) {
        Jedis redis = j.getResource();
        redis.select(index);
        redis.incr(key);
        redis.close();
    }

    public String get(int index, String key) {
        Jedis redis = j.getResource();
        redis.select(index);
        String value = redis.get(key);
        redis.close();
        return value;
    }

    public boolean existsKey(int index, String key) {
        Jedis redis = j.getResource();
        redis.select(index);
        if (redis.exists(key)) {
            return true;
        }
        return false;
    }
}
