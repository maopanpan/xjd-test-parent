package com.hz.xjd.console.security.cache;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import com.hz.xjd.common.constants.Constants;


/**
 *
 * session redis实现
 *
 */
public class RedisSessionDao extends AbstractSessionDAO {

	private static Logger logger = LoggerFactory.getLogger(RedisSessionDao.class);

	@Autowired
	private transient RedisTemplate<Serializable, Session> redisTemplate;

	@Override
	public void update(Session session) throws UnknownSessionException {
		logger.info("update shiro session ,sessionId is :{}", session.getId().toString());
		redisTemplate.opsForValue().set(session.getId(), session, Constants.shiro_timeout, TimeUnit.SECONDS);
	}

	@Override
	public void delete(Session session) {
		logger.info("delete shiro session ,sessionId is :{}", session.getId().toString());
		redisTemplate.opsForValue().getOperations().delete(session.getId());
	}

	@Override
	public Collection<Session> getActiveSessions() {
		Set<Serializable> keys = redisTemplate.keys(Constants.shiro_session_prefix_keys);
		if (keys.size() == 0) {
			return Collections.emptySet();
		}
		List<Session> sessions = redisTemplate.opsForValue().multiGet(keys);
		return Collections.unmodifiableCollection(sessions);
	}

	@Override
	protected Serializable doCreate(Session session) {
		Serializable sessionId = Constants.shiro_session_prefix + UUID.randomUUID().toString();
		assignSessionId(session, sessionId);
		redisTemplate.opsForValue().set(sessionId, session, Constants.shiro_timeout, TimeUnit.SECONDS);
		logger.info("create shiro session ,sessionId is :{}", sessionId.toString());
		return sessionId;
	}

	@Override
	protected Session doReadSession(Serializable sessionId) {
		logger.info("read shiro session ,sessionId is :{}", sessionId.toString());
		return redisTemplate.opsForValue().get(sessionId);
	}

}
