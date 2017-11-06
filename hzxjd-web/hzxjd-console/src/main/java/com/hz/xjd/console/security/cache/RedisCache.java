package com.hz.xjd.console.security.cache;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.hz.xjd.common.constants.Constants;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 *
 * cache redis实现
 *
 */
public class RedisCache<K, V> implements Cache<K, V>, Serializable {

	private static final long serialVersionUID = 7605186383244433965L;
	private static Logger logger = LoggerFactory.getLogger(RedisCache.class);

	private transient RedisTemplate<K, V> redisTemplate;

	/**
	 * 构造函数
	 */
	public RedisCache(RedisTemplate<K, V> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}
	public RedisCache() {

	}
	/**
	 * 取得key的redis值
	 */
	@Override
	public V get(K key) throws CacheException {
		logger.debug("根据key:{}从redis获取对象", key);
		logger.debug("redisTemplate : {}", redisTemplate);
		return redisTemplate.opsForValue().get(Constants.shiro_cache_prefix + key);
	}
	/**
	 * 添加{key，value}的redis对象
	 */
	@SuppressWarnings("unchecked")
	@Override
	public V put(K key, V value) throws CacheException {
		logger.debug("根据key:{}设置redis对象value{}", key,value);
		redisTemplate.opsForValue().set((K) (Constants.shiro_cache_prefix + key), value, Constants.shiro_timeout, TimeUnit.SECONDS);
		return value;
	}
	/**
	 * 删除key的redis值
	 */
	@Override
	public V remove(K key) throws CacheException {
		logger.debug("根据key:{}从redis删除对象", key);
		V value = redisTemplate.opsForValue().get(Constants.shiro_cache_prefix + key);
		redisTemplate.delete(key);
		return value;
	}
	/**
	 * 删除key的redis值
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void clear() throws CacheException {
		logger.debug("清除redis所有缓存对象");
		Set<K> keys = redisTemplate.keys((K) Constants.shiro_cache_prefix_keys);
		redisTemplate.delete(keys);
	}

	/**
	 * 取得redis缓存对象数量
	 */
	@SuppressWarnings("unchecked")
	@Override
	public int size() {
		Set<K> keys = redisTemplate.keys((K) Constants.shiro_cache_prefix_keys);
		logger.debug("获取redis缓存对象数量:{}", keys.size());
		return keys.size();
	}
	/**
	 * 取得所以redis缓存对象的key
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Set<K> keys() {
		Set<K> keys = redisTemplate.keys((K) Constants.shiro_cache_prefix_keys);
		logger.debug("获取所有缓存对象的key");
		if (keys.size() == 0) {
			return Collections.emptySet();
		}
		return keys;
	}
	/**
	 * 取得所以redis缓存对象的value
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Collection<V> values() {
		Set<K> keys = redisTemplate.keys((K) Constants.shiro_cache_prefix_keys);
		logger.debug("获取所有缓存对象的value");
		if (keys.size() == 0) {
			return Collections.emptySet();
		}
		List<V> vs = redisTemplate.opsForValue().multiGet(keys);
		return Collections.unmodifiableCollection(vs);
	}
	public RedisTemplate<K, V> getRedisTemplate() {
		return redisTemplate;
	}
	public void setRedisTemplate(RedisTemplate<K, V> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}
}
