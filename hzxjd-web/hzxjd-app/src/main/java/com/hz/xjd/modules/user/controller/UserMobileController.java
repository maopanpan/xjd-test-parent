package com.hz.xjd.modules.user.controller;

import com.hz.xjd.app.abilitys.encryptors.RSAEncryptor;
import com.hz.xjd.app.constants.DigitalAndStringConstant;
import com.hz.xjd.app.utils.DecryptPropertyPlaceholderConfigurer;
import com.hz.xjd.app.web.controller.AppBaseController;
import com.hz.xjd.biz.user.service.UserMobileService;
import com.hz.xjd.common.constants.IResultsCode;
import com.hz.xjd.common.model.BaseDataResp;
import com.hz.xjd.common.model.BaseReq;
import com.hz.xjd.common.vo.app.user.LoginBean;
import com.hz.xjd.model.user.entity.UserMobile;
import net.sf.ehcache.Element;
import org.apache.commons.codec.binary.Base64;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


/**
 * @Author: maopanpan
 * @Description: 用户登录、退出接口操作
 * @Date: 2017/11/03.
 **/
@Controller
@RequestMapping("/user")
public class UserMobileController extends AppBaseController {

    private Logger logger = LoggerFactory.getLogger(UserMobileController.class);

    /**
     * RAS公钥
     */
    @Value("${rsa.publicKey}")
    private String rsaPublicKey;

    @Autowired
    private UserMobileService userMobileService;

    /**
     * 用户登录
     * @param request
     * @param v
     * @param httpEntity
     * @return
     */
    @RequestMapping(value = "/{v}/login", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Object login(HttpServletRequest request, @PathVariable String v, HttpEntity<LoginBean> httpEntity) {
        logger.info("【登录】请求参数：" + httpEntity.getBody());

        BaseDataResp resp = this.validator(httpEntity);
        if (!IResultsCode.SUCCESS.getKey().equals(resp.getCode())) {
            logger.error("【登录】请求参数校验异常:" + resp);
            return resp;
        }
        //获取登录参数
        LoginBean loginBean = httpEntity.getBody();

        try {
            resp = userMobileService.login(loginBean);
            if (!IResultsCode.SUCCESS.getKey().equals(resp.getCode())) {
                return resp;
            }

            UserMobile userMobile = (UserMobile) resp.getData();
            Map<String, Object> map = new HashMap<String, Object>();

            //生成TOKEN
            getToken(httpEntity.getBody().getImei(), userMobile, map);
            resp.setCode(IResultsCode.SUCCESS);
            resp.setData(map);
            return resp;

        } catch (Exception e) {
            logger.error("【登录】用记{}登录失败", loginBean.getMobile());
            resp.setCode(IResultsCode.USER_LOGIN_ERROR);
            return resp;
        }
    }

    /**
     * 用户拿出登录
     * @param v
     * @param httpEntity
     * @param request
     * @return
     */
    @RequestMapping(value = "/{v}/logout", method = RequestMethod.POST, produces = {"application/json", "application/xml"})
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Object logout(@PathVariable String v, HttpEntity<BaseReq> httpEntity, HttpServletRequest request) {
        logger.info("【logout】请求参数:" + httpEntity.getBody());
        BaseDataResp resp = new BaseDataResp();
        SecurityUtils.getSubject().logout();
        this.removeUserIdByAuthorization(request);
        resp.setCode(IResultsCode.SUCCESS);
        logger.info("【logout】APP退出成功:" + resp);
        return resp;
    }

    /**
     * 生成登录Token
     *
     * @param imei
     * @param uMobile
     * @param map
     * @throws Exception
     */
    private void getToken(String imei, UserMobile uMobile, Map<String, Object> map) throws Exception {
        String temp = uMobile.getId() + "&" + (imei == null ? "" : imei);
        long time = System.currentTimeMillis() + DigitalAndStringConstant.DigitalConstant.MILLISECOND_SEVEN_DAY;
        byte[] publicKey = Base64.decodeBase64(rsaPublicKey);
        String token = Base64.encodeBase64String(RSAEncryptor.encryptByPublicKey((temp + "&" + time).getBytes(), publicKey));
        logger.info("【登录】用户{}登录成功，生成Token:{}", uMobile.getMobile(), token);
        map.put("token", token);
        loginCache.put(new Element(token, uMobile.getId()));
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.login(new UsernamePasswordToken(String.valueOf(uMobile.getId()), token));
        loginCache.put(new Element(temp, time));
    }


}
