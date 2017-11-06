package com.hz.xjd.biz.user.service.impl;

import com.hz.xjd.common.constants.Constants;
import com.hz.xjd.common.constants.IResultsCode;
import com.hz.xjd.common.constants.ResponseCode;
import com.hz.xjd.common.model.BaseDataResp;
import com.hz.xjd.common.model.LoginBean;
import com.hz.xjd.common.model.Result;
import com.hz.xjd.common.utils.StringUtils;
import com.hz.xjd.manager.RedisManager;
import com.hz.xjd.model.log.entity.LogSysException;
import com.hz.xjd.model.log.entity.LogUserLogin;
import com.hz.xjd.mybatis.log.dao.LogUserLoginMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hz.xjd.biz.base.service.BaseService;
import com.hz.xjd.biz.user.service.UserMobileService;
import com.hz.xjd.model.user.entity.UserMobile;
import com.hz.xjd.mybatis.user.dao.UserMobileMapper;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

/**
 * 用户账户操作
 */
@Service
public class UserMobileServiceImpl extends BaseService<UserMobileMapper, UserMobile> implements UserMobileService {

    private Logger logger = LoggerFactory.getLogger(UserMobile.class);

    @Autowired
    private UserMobileMapper userMobileMapper;
    @Autowired
    private LogUserLoginMapper logUserLoginDao;
    @Autowired
    private RedisManager redisManager;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public BaseDataResp login(com.hz.xjd.common.vo.app.user.LoginBean loginBean) {
        BaseDataResp baseResp = new BaseDataResp();
        //手机号
        String mobile = loginBean.getMobile();
        //手机验证码
        String verifyCode = loginBean.getVerifyCode();

        if (StringUtils.isEmpty(mobile)) {
            logger.error("【登录】手机号为空");
            baseResp.setCode(IResultsCode.ERROR_PARAMETER, "手机号不能为空");
            return baseResp;
        }

        if (StringUtils.isEmpty("verifyCode")) {
            logger.error("【登录】手机校验码为空");
            baseResp.setCode(IResultsCode.ERROR_PARAMETER, "手机校验码不能为空");
            return baseResp;
        }

        if (!StringUtils.isMobile(mobile)) {
            logger.error("【登录】手机号{}格式异常", mobile);
            baseResp.setCode(IResultsCode.ERROR_PARAMETER, "手机号格式异常");
            return baseResp;
        }

        if (!isRegister(mobile)) {
            //示注册用户
            UserMobile userMobile = new UserMobile();
            userMobile.setLoginName(mobile);
            userMobile.setMobile(mobile);
            userMobile.setPassword("");
            userMobile.setUserNo("-");
            userMobile.setFailureTimes(0);
            userMobile.setLastLogintime(new Date());
            userMobile.setCreateTime(new Date());
            userMobile.setDeleteFlg(0);
            userMobileMapper.insert(userMobile);
            baseResp.setCode(IResultsCode.SUCCESS, IResultsCode.SUCCESS.getDescription());
        }

        //构建短信验证码存储路径
        String smsKey = Constants.VALIDATE_CODE + ":" + mobile;
        redisManager.set(Constants.vIndex, smsKey, 120, verifyCode);
        String sendCode = redisManager.get(Constants.vIndex, smsKey);
        if (StringUtils.isEmpty(sendCode)) {
            logger.error("【登录】用户{}请获取短信验证码", mobile);
            baseResp.setCode(IResultsCode.ERROR_VER_CODE, "请获取短信验证码");
            return baseResp;
        }

        if (!sendCode.equals(verifyCode)) {
            logger.error("【登录】用户{}短信验证码错误，请重新获取短信验证码", mobile);
            baseResp.setCode(IResultsCode.ERROR_VER_CODE, "短信验证码错误，请重新获取短信验证码");
            return baseResp;
        }

        /**
         * 查询用户信息
         */
        UserMobile pMobile = new UserMobile();
        pMobile.setMobile(mobile);
        pMobile.setDeleteFlg(Constants.INT_ZERO);
        UserMobile userMobile = userMobileMapper.selectOne(pMobile);

        baseResp.setCode(IResultsCode.SUCCESS);
        baseResp.setData(userMobile);
        return baseResp;

    }

//    /**
//     * 用户注册
//     *
//     * @param loginBean
//     * @throws Exception
//     */
//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    public BaseDataResp register(LoginBean loginBean) {
//        BaseDataResp baseResp = new BaseDataResp();
//        String accountName = loginBean.getAccountName();
//        String password = loginBean.getPassword();
//        if (!StringUtils.isMobile(accountName)) {
//            logger.error("【注册】手机号{}格式异常", accountName);
//            baseResp.setCode(IResultsCode.ERROR_PARAMETER, IResultsCode.ERROR_PARAMETER.getDescription());
//            return baseResp;
//        }
//
//        //判断账户是否已注册
//        if (isRegister(accountName)) {
//            logger.error("【注册】手机号{}已存在", accountName);
//            baseResp.setCode(IResultsCode.USER_REGISTER, IResultsCode.USER_REGISTER.getDescription());
//            return baseResp;
//        }
//
//        try {
//            UserMobile userMobile = new UserMobile();
//            userMobile.setLoginName(accountName);
//            userMobile.setMobile(accountName);
//            userMobile.setPassword(password);
//            userMobile.setUserNo("-");
//            userMobile.setFailureTimes(0);
//            userMobile.setLastLogintime(new Date());
//            userMobile.setCreateTime(new Date());
//            userMobile.setDeleteFlg(0);
//            userMobileMapper.insert(userMobile);
//            baseResp.setCode(IResultsCode.SUCCESS, IResultsCode.SUCCESS.getDescription());
//        } catch (Exception e) {
//            e.printStackTrace();
//            logger.error("【注册】用户{}注册失败", accountName, e);
//            baseResp.setCode(IResultsCode.ERROR_UNKNOWN, IResultsCode.ERROR_UNKNOWN.getDescription());
//        }
//
//        return baseResp;
//    }
//
//    /**
//     * 用户登录
//     *
//     * @param loginBean
//     * @return
//     */
//    @Override
//    public BaseDataResp login(LoginBean loginBean) {
//        //返回结果定义
//        BaseDataResp baseResp = new BaseDataResp();
//        //登录账号（手机号）
//        String mobile = loginBean.getAccountName();
//        //短信验证码为空，且登录密码非空时，认为是密码登录
//        String verifyCode = loginBean.getVerifyCode();
//        //登录密码
//        String password = loginBean.getPassword();
//        try {
//            //登录账号为空
//            if (StringUtils.isEmpty(accountName)) {
//                logger.error("【登录】登录账号异常");
//                baseResp.setCode(IResultsCode.ERROR_PARAMETER, IResultsCode.ERROR_PARAMETER.getDescription());
//                return baseResp;
//            }
//
//            //登录密码及登录验证码为空
//            if (StringUtils.isEmpty(verifyCode) && StringUtils.isEmpty(password)) {
//                logger.error("【登录】登录账号异常");
//                baseResp.setCode(IResultsCode.ERROR_PARAMETER, IResultsCode.ERROR_PARAMETER.getDescription());
//                return baseResp;
//            }
//
//            //检测手机号
//            if (!StringUtils.isMobile(accountName)) {
//                logger.error("【登录】登录账号{}检测异常", accountName);
//                baseResp.setCode(IResultsCode.ERROR_PARAMETER, IResultsCode.ERROR_PARAMETER.getDescription());
//                return baseResp;
//            }
//
//            UserMobile pMobile = new UserMobile();
//            pMobile.setMobile(accountName);
//            pMobile.setDeleteFlg(Constants.INT_ZERO);
//            UserMobile userMobile = userMobileMapper.selectOne(pMobile);
//
//            if (userMobile == null) {
//                logger.error("【登录】登录账号{}不存在", accountName);
//                baseResp.setCode(IResultsCode.USER_NOT_REGISTER, IResultsCode.USER_NOT_REGISTER.getDescription());
//                return baseResp;
//            }
//
//            LogUserLogin logUserLogin = new LogUserLogin();
//
//            logUserLogin.setMobile(userMobile.getMobile());
//            logUserLogin.setUserNo(userMobile.getUserNo());
//            logUserLogin.setLoginTime(new Timestamp(new Date().getTime()));
//            logUserLogin.setIp(loginBean.getIp());
//
//            //密码登录
//            if (StringUtils.isNotEmpty(password) && StringUtils.isEmpty(verifyCode)) {
//                String psw = userMobile.getPassword();
//                //密码错误
//                if (!psw.equals(password)) {
//                    logger.error("【登录】密码{}|{}错误", psw, password);
//                    logUserLogin.setSuccess(Constants.NO);
//                    logUserLogin.setFailCuase(Constants.USER_LOGIN_ERRORNAME);
//                    logUserLoginDao.insert(logUserLogin);
//                    baseResp.setCode(IResultsCode.USER_ERROR_PASSWORD, IResultsCode.USER_ERROR_PASSWORD.getDescription());
//                    return baseResp;
//                }
//
//                logUserLogin.setSuccess(Constants.YES);
//                logUserLoginDao.insert(logUserLogin);
//                //更新最后的登录时间
//                UserMobile tMobile = new UserMobile();
//                tMobile.setId(userMobile.getId());
//                tMobile.setLastLogintime(new Timestamp(new Date().getTime()));
//                userMobileMapper.updateByPrimaryKeySelective(tMobile);
//
//                baseResp.setCode(IResultsCode.SUCCESS, IResultsCode.SUCCESS.getDescription());
//                baseResp.setData(tMobile);
//                return baseResp;
//
//            }
//
//            //短信验证码登录
//            else if (StringUtils.isEmpty(password) && StringUtils.isNotEmpty(verifyCode)) {
//                //发送验证号
//                String code = "";
//                //验证码错误
//                if (!code.equals(verifyCode)) {
//                    logger.error("【登录】验证码{}|{}错误", code, verifyCode);
//                    logUserLogin.setSuccess(Constants.NO);
//                    logUserLogin.setFailCuase(Constants.USER_LOGIN_ERRORNAME);
//                    logUserLoginDao.insert(logUserLogin);
//                    baseResp.setCode(IResultsCode.ERROR_VER_CODE, IResultsCode.ERROR_VER_CODE.getDescription());
//                    return baseResp;
//                }
//
//                logUserLogin.setSuccess(Constants.YES);
//                logUserLoginDao.insert(logUserLogin);
//                //更新最后的登录时间
//                UserMobile tMobile = new UserMobile();
//                tMobile.setId(userMobile.getId());
//                tMobile.setLastLogintime(new Timestamp(new Date().getTime()));
//                userMobileMapper.updateByPrimaryKeySelective(tMobile);
//
//                baseResp.setCode(IResultsCode.SUCCESS, IResultsCode.SUCCESS.getDescription());
//                baseResp.setData(tMobile);
//                return baseResp;
//            } else {
//                baseResp.setCode(IResultsCode.ERROR_UNKNOWN, IResultsCode.ERROR_UNKNOWN.getDescription());
//                return baseResp;
//            }
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            logger.error("【登录】请求处理异常", e);
//            baseResp.setCode(IResultsCode.ERROR_UNKNOWN, IResultsCode.ERROR_UNKNOWN.getDescription());
//            return baseResp;
//        }
//    }
//
//

    /**
     * 检测账户是否已经存在
     *
     * @param accountName
     * @return
     */
    private boolean isRegister(String accountName) {
        if (StringUtils.isEmpty(accountName)) {
            return false;
        }
        UserMobile userMobile = new UserMobile();
        userMobile.setMobile(accountName);
        userMobile.setDeleteFlg(0);

        UserMobile uMobile = userMobileMapper.selectOne(userMobile);
        if (uMobile != null) {
            return true;
        }
        return false;
    }
}
