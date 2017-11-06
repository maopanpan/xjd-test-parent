package com.hz.xjd.app.abilitys.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Service;

@Service
public class MyShiroRealm extends AuthorizingRealm
{
    //    private IBaseDao baseDao;

    /**
     *  登录回调函数
     */

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
        throws AuthenticationException
    {
        UsernamePasswordToken token = (UsernamePasswordToken)authcToken;
        return new SimpleAuthenticationInfo(token.getUsername(), token.getPassword(), token.getUsername());
    }

    /**
     * 认证回调函数，返回Authorization凭证集合
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0)
    {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        return info;
    }
}
