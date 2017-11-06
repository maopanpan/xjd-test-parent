package com.hz.xjd.console.security.shiro.realm;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import com.hz.xjd.common.constants.Constants;
import com.hz.xjd.model.sys.entity.SysFunction;
import com.hz.xjd.model.sys.entity.SysRole;
import com.hz.xjd.model.sys.entity.SysUser;
import com.hz.xjd.mybatis.sys.dao.SysFunctionMapper;
import com.hz.xjd.mybatis.sys.dao.SysRoleFunctionMapper;
import com.hz.xjd.mybatis.sys.dao.SysRoleMapper;
import com.hz.xjd.mybatis.sys.dao.SysUserMapper;
import com.hz.xjd.mybatis.sys.dao.SysUserRoleMapper;

public class SystemAuthorizingRealm extends AuthorizingRealm {

	private static Logger logger = LoggerFactory.getLogger(SystemAuthorizingRealm.class);

	@Autowired
	private SysUserMapper sysUserMapper;
	@Autowired
	private SysUserRoleMapper sysUserRoleMapper;
	@Autowired
	private SysRoleMapper sysRoleMapper;
	@Autowired
	private SysRoleFunctionMapper sysRoleFunctionMapper;
	@Autowired
	private SysFunctionMapper sysFunctionMapper;
	@Autowired
	private RedisTemplate<Object, Object> redisTemplate;

	/**
	 * 鉴权信息
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		logger.debug("开始查询授权信息");
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		//从 principals获取主身份信息
		//将getPrimaryPrincipal方法返回值转为真实身份类型（在上边的doGetAuthenticationInfo认证通过填充到SimpleAuthenticationInfo中身份类型）
		String loginName = (String) principals.getPrimaryPrincipal();
		// 根据身份信息获取权限信息,
		SysUser sysUser = sysUserMapper.selectUserByLoginName(loginName);
		if (sysUser != null) {
			//从数据库获取到权限信息
			Set<String> permissions = new HashSet<>();
			Set<String> roles = new HashSet<>();
			//取得用户对应的角色
			List<Integer> userRoles = sysUserRoleMapper.selectRoleBySysUserId(sysUser.getId());
			for (Integer roleId:userRoles) {
				SysRole sysRole = sysRoleMapper.selectByRoleId(roleId);
				roles.add(sysRole.getRoleName());
				//取得角色对应的权限信息
				List<Integer> roleFunctions = sysRoleFunctionMapper.selectFunctionByRoleId(roleId);
				for (Integer functionId:roleFunctions) {
					SysFunction sysFunction = sysFunctionMapper.selectByFunctionId(functionId);
					permissions.add(sysFunction.getFunctionCode());
				}
			}
			info.addRoles(roles);
			info.addStringPermissions(permissions);
			logger.debug("角色信息: \n {}", roles.toString());
			logger.debug("权限信息: \n{}", permissions.toString());
		}
		logger.debug("结束查询授权信息");
		return info;
	}
	/**
	 * 登录验证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		logger.debug("开始登录验证");
		//从token中取出身份信息（token代表用户输入的传下来的信息）
		String loginName = (String) token.getPrincipal();
		// 根据身份信息获取用户信息
		SysUser sysUser = sysUserMapper.selectUserByLoginName(loginName);
		//返回认证信息由父类AuthenticatingRealm进行认证
		AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(loginName, sysUser.getPassword(),  getName());
		return authenticationInfo;
	}

	@Override
	protected void doClearCache(PrincipalCollection principals) {
		redisTemplate.delete(Constants.shiro_cache_prefix + principals.getPrimaryPrincipal().toString());
	}

	@Override
	protected void clearCachedAuthorizationInfo(PrincipalCollection principals) {
		logger.debug("clearCachedAuthorizationInfo");
	}
}
