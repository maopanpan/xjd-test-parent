/*
 * 文 件 名:  IResultsCode.java
 * 版    权:  © 2013 dimeng. All rights reserved.
 * 描    述:  <描述>
 * 修 改 人:  tonglei
 * 修改时间:  2015-06-17

 */
package com.hz.xjd.app.constants;

import org.springframework.util.StringUtils;

/**
 * 返回结果统一定义
 * <功能详细描述>
 *
 * @author tonglei
 * @version [版本号, 2015-06-17]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public enum IResultsCode
{
    /**
     * 公共部分0开头
     */
    HTTP_OK("200", "HTTP请求成功"),

    HTTP_ERROR("000500", "HTTP请求成功"),

    SUCCESS("000000", "成功"),

    ERROR_UNKNOWN("000001", "未知异常"),

    ERROR_DATABASE_OP("000002", "数据库操作错误"),

    ERROR_PARAMETER("000003", "参数格式错误，或参数不能为空"),

    ERROR_UPLOAD_IO("000004", "文件上传错误"),

    ERROR_NO_SUPPORT_OP("000005", "不支持的操作类型"),

    ERROR_MAX_UPLOAD_SIZE("000006", "超出文件上传最大限制"),

    ERROR_VER_CODE("000007", "验证码错误"),

    ERROR_GET_VER_CODE_OUT_LIMIT_COUNT("000008", "获取验证码次数超过限制"),

    INT_SUCCESS_DATABASE_OP("000009", "数据库操作成功"),

    SYS_ERROR("000010", "系统错误"),

    FAILURE("000011", "失败"),

    /**
     * 用户部分2开头
     */
    USER_ERROR_DIS_ACCREDIT("200001", "未登录，用户需要登录"),

    USER_ERROR_USERNAME_OR_PASSWORD("200002", "用户名或密码有误，请重试！"),

    USER_ERROR_USERNAME_NO_PERMISSION("200003", "用户无权限操作"),

    USER_ERROR_USERNAME_VERCODE_INVALID("200004", "验证码无效或超时"),

    USER_ERROR_USERNAME_REALNAME_INVALID("200005", "请输入真实姓名或者真实姓名不是中文"),

    USER_ERROR_USERNAME_IDCARD_INVALID("200006", "请输入身份证号或者身份证号不正确"),

    USER_LOGIN_ERROR("200007", "用户名登录错误"),

    USER_LOGIN_LOCK("200008", "您的帐号已被锁定."),

    USER_ERROR_OLD_PWD_INVALID("200009", "请输入正确的原登陆密码"),

    USER_ERROR_PWD_DIFFER_INVALID("200010", "新交易密码不能与登陆密码一致"),

    USER_ERROR_NEW_PWD_INVALID("200011", "请输入正确格式的新登陆密码"),

    USER_SAFETY_CERT_NOT_ALL("200012", "用户安全信息认证不完全"),

    USER_ERROR_BIND_PHONE("200013", "注册时绑定手机失败"),

    USER_DEAL_PASSWORD_ERROR("200014","交易密码验证失败，请输入正确的交易密码！"),

    USER_LOGIN_DENY_ERROR("200015","移动终端不支持非个人用户登录！"),

    USER_REALNAME_NOT_AUTHEN("200016","用户身份信息未认证！"),

    USER_EMAIL_NOT_AUTHEN("200017","用户邮箱未认证！"),

    USER_MOBILE_NOT_AUTHEN("200018","用户手机号码未认证！"),

    USER_HAVE_YUQIUNPAID("200019","您有逾期借款未还，请先还清逾期借款"),
    /**
     * platinfo部分3开头
     */
    PLATINFO_EMAIL_NOT_EXIST("300001", "邮箱不存在"),

    PLATINFO_EMAIL_NOT_TIED("300002", "未绑定邮箱"),

    PLATINFO_PHONE_NOT_EXIST("300003", "手机不存在"),

    PLATINFO_PHONE_NOT_TIED("300004", "未绑定手机"),

    PLATINFO_PHONE_INVALID("300005", "请输入正确的手机号码"),

    PLATINFO_VERIFY_CODE_INVALID("300006", "请输入正确的验证码"),

    PLATINFO_EMAIL_LENGTH_ERROR("300007", "请输入6到60个字符的邮件地址"),

    PLATINFO_EMAIL_INVALID("300008", "请输入正确格式的邮件");

    protected final String key;

    protected final String description;

    private IResultsCode(String key, String description)
    {
        this.key = key;
        this.description = description;
    }

    public String getKey()
    {
        return key;
    }

    public String getDescription()
    {
        return description;
    }

    /**
     * 解析字符串.
     *
     * @return IResultsCode
     */
    public static final IResultsCode parse(String value)
    {
        if (StringUtils.isEmpty(value))
        {
            return null;
        }
        try
        {
            return IResultsCode.valueOf(value);
        }
        catch (Throwable t)
        {
            return null;
        }
    }

}
