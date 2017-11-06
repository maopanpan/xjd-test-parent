/*
 * 文 件 名:  PlatformAuthenticationFilter.java
 * 版    权:  © 2013 dimeng. All rights reserved.
 * 描    述:  <描述>
 * 修 改 人:  huanggang
 * 修改时间:  2014-2-17
 */
package com.hz.xjd.app.abilitys.shiro;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.hz.xjd.app.utils.DES3Util;
import com.hz.xjd.common.constants.IResultsCode;
import com.hz.xjd.common.model.BaseResp;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.AuthenticationFilter;

import com.hz.xjd.app.abilitys.encryptors.RSAEncryptor;
import com.hz.xjd.app.constants.DigitalAndStringConstant;
import com.hz.xjd.app.utils.DecryptPropertyPlaceholderConfigurer;

import net.sf.ehcache.Cache;
import org.springframework.beans.factory.annotation.Value;


/**
 * shiro 自定义过滤器
 *
 * @author  huanggang
 * @version  [版本号, 2013-12-17]
 */
public class PlatformAuthenticationFilter extends AuthenticationFilter
{
    private static final Log log = LogFactory.getLog(PlatformAuthenticationFilter.class);

    @Resource(name = "loginCache")
    private Cache loginCache;

    private final byte[] privateKey =
        Base64.decodeBase64((String)DecryptPropertyPlaceholderConfigurer.getProperties("rsa.privateKey"));

    /**
     * 3DES加密密钥
     */
    @Value("${3des.secret.key}")
    private String _3DES_SECRET_KEY;

    /**
     * 把错误信息写到response
     * @param response
     * @param baseResp
     * @throws IOException
     * @see [类、类#方法、类#成员]
     */
    private void whriteJsonToResponse(ServletResponse response, BaseResp baseResp)
        throws IOException
    {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print(DES3Util.encryptMode(baseResp.toString(), _3DES_SECRET_KEY));
        log.error("PlatformAuthenticationFilter whriteJsonToResponse BaseResp =" + baseResp);
        response.flushBuffer();

    }

    /**
     * 访问被拒绝
     *
     **/
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response)
        throws Exception
    {
        return true;
    }

    /**
     * shiro过滤器
     */
    @Override
    public void doFilterInternal(ServletRequest request, ServletResponse response, FilterChain filterChain)
        throws ServletException, IOException
    {
        String authentication = ((HttpServletRequest)request).getHeader("Authorization");
        // 令牌为空
        if (StringUtils.isBlank(authentication))
        {
            BaseResp baseResp = new BaseResp();
            baseResp.setCode(IResultsCode.USER_ERROR_DIS_ACCREDIT);
            whriteJsonToResponse(response, baseResp);
            return;
        }
        try
        {
            if(loginCache.get(authentication)==null){
                BaseResp baseResp = new BaseResp();
                baseResp.setCode(IResultsCode.USER_ERROR_DIS_ACCREDIT);
                whriteJsonToResponse(response, baseResp);
                return;
            }
            String body = new String(RSAEncryptor.decryptByPrivateKey(Base64.decodeBase64(authentication), privateKey));
            String[] body3 = body.split("&");
            long time =
                (long)loginCache.get(body3[DigitalAndStringConstant.DigitalConstant.ZERO] + "&"
                    + body3[DigitalAndStringConstant.DigitalConstant.ONE]).getObjectValue();
            if (time != Long.parseLong(body3[DigitalAndStringConstant.DigitalConstant.TWO])
                || time == DigitalAndStringConstant.DigitalConstant.ZERO)
            {
                BaseResp baseResp = new BaseResp();
                baseResp.setCode(IResultsCode.USER_ERROR_DIS_ACCREDIT);
                whriteJsonToResponse(response, baseResp);
                return;
            }
            if (System.currentTimeMillis() > time)
            {
                BaseResp baseResp = new BaseResp();
                baseResp.setCode(IResultsCode.USER_ERROR_DIS_ACCREDIT);
                whriteJsonToResponse(response, baseResp);
                return;
            }

            Subject currentUser = SecurityUtils.getSubject();
            //调用业务层处理 resp = xxxx.xxxx();
            UsernamePasswordToken token =
                new UsernamePasswordToken(body3[DigitalAndStringConstant.DigitalConstant.ZERO], authentication);
            currentUser.login(token);
        }
        catch (Exception e)
        {
            log.error("PlatformAuthenticationFilter doFilterInternal ! " + e);
            BaseResp baseResp = new BaseResp();
            baseResp.setCode(IResultsCode.USER_ERROR_DIS_ACCREDIT);
            whriteJsonToResponse(response, baseResp);
            return;
        }
        super.doFilterInternal(request, response, filterChain);
    }
}