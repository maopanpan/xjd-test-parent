package com.hz.xjd.common.constants;

public class Constants {
    public static final String CURR_USER = "currUser";
    public static final String CURR_ADMIN = "currAdmin";
    public static final int ADMIN_ID = 1;
    //shiro
    public static final String shiro_cache_prefix = "shiro-cache-";
    public static final String shiro_cache_prefix_keys = "shiro-cache-*";
    public static final String shiro_session_prefix = "shiro-session-";
    public static final String shiro_session_prefix_keys = "shiro-session-*";

    public static final long shiro_timeout = 2592000;
    //
    public static final int INT_ZERO = 0;
    public static final int INT_ONE = 1;
    //
    public static final int STR_ZERO = 0;
    public static final int STR_ONE = 1;
    //
    public static final String YES = "yes";
    public static final String NO = "no";
    /**
     * 用户登陆错误编号
     */
    // 用户名和密码错误
    public static final String USER_LOGIN_ERRORNAME = "1";
    // 用户被锁
    public static final String USER_LOGIN_LOCKED = "2";
    // 用户被拉黑
    public static final String USER_LOGIN_BLACK = "3";

    // 显示/隐藏
    public static final String SHOW = "1";
    public static final String HIDE = "0";
    // 对/错
    public static final String TRUE = "true";
    public static final String FALSE = "false";
    //验证码
    public static final String VALIDATE_CODE = "validateCode";
    //短信验证码Redis库
    public static final int vIndex = 3;
    //设置短信的存活周期
    public static final int SMS_LIVE_TIME = 60 * 2;
}
