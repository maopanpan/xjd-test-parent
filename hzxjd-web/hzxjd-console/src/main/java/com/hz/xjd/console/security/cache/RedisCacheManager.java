package com.hz.xjd.console.security.cache;

import java.io.Serializable;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.hz.xjd.common.constants.Constants;

/**
 *
 * 缓存管理
 *
 */
public class RedisCacheManager implements CacheManager, Serializable {

	private static final long serialVersionUID = 143529633027461189L;

	private static Logger logger = LoggerFactory.getLogger(RedisCacheManager.class);

	private transient RedisTemplate<Object, Object> redisTemplate;

	public RedisCacheManager() {

	}

	/**
	 * 取得缓存
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public <K, V> Cache<K, V> getCache(String name) throws CacheException {
		if (!StringUtils.hasText(name)) {
			throw new IllegalArgumentException("Cache name cannot be null or empty.");
		}
		logger.debug("redis cache manager get cache name is :{}", name);

		Cache cache = (Cache) redisTemplate.opsForValue().get(name);
		if (cache == null) {
			cache = new RedisCache<>(redisTemplate);
			redisTemplate.opsForValue().set(Constants.shiro_cache_prefix + name, cache);
		}

		return cache;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void setRedisTemplate(RedisTemplate redisTemplate) {
		this.redisTemplate = redisTemplate;
	}
}
