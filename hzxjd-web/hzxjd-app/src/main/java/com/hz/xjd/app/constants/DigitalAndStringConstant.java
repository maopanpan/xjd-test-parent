/*
 * 文 件 名:  DigitalConstant.java
 * 版    权:  © 2012 dimeng. All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  huanggang
 * 修改时间:  2014-2-3
 */
package com.hz.xjd.app.constants;

/**
 * 数字和对应字符常量定义
 * <功能详细描述>
 *
 * @author  huanggang
 * @version  [版本号, 2015-06-3]
 */
public interface DigitalAndStringConstant
{
    /**
     *
     * 数字常量
     * <功能详细描述>
     *
     * @author  huanggang
     * @version  [版本号, 2015-06-3]
     */
    interface DigitalConstant
    {

        /**
         * -1
         */
        int NEGATIVE = -1;

        /**
         * 0
         */
        int ZERO = 0;

        /**
         * 1
         */
        int ONE = 1;

        /**
         * 2
         */
        int TWO = 2;

        /**
         * 3
         */
        int THREE = 3;

        /**
         * 4
         */
        int FOUR = 4;

        /**
         * 5
         */
        int FIVE = 5;

        /**
         * 6
         */
        int SIX = 6;

        /**
         * 7
         */
        int SEVEN = 7;

        /**
         * 8
         */
        int EIGHT = 8;

        /**
         * 9
         */
        int NINE = 9;

        /**
         * 9
         */
        int TEN = 10;

        /**
         * 数字16
         */
        int NUM_SIXTEEN = 16;

        /**
         * 20
         */
        int TWENTY = 20;

        /**
         * 50
         */
        int FIFTY = 50;

        /**
         * 36
         */
        int THIRTY_SIX = 36;

        /**
         * 数字200 Two hundred
         */
        int TWO_HUNDRED = 200;

        /**
         * 一小时3600000毫秒
         */
        long MILLISECOND_HOURTOM = 3600000;

        /**
         * 7天604800000毫秒
         */
        long MILLISECOND_SEVEN_DAY = 604800000;

        /**
         * 一分钟60000毫秒
         */
        long MINTOM = 60000;

        /**
         * 一分钟60000毫秒
         */
        int IMINTOM = 60000;
    }

    /**
     *
     * 字符数字常量
     * <功能详细描述>
     *
     * @author  huanggang
     * @version  [版本号, 2015-06-3]
     */
    interface StringConstant
    {
        /**
         * 0
         */
        String ZERO = "0";

        /**
         * 1
         */
        String ONE = "1";

        /**
         * 2
         */
        String TWO = "2";

        /**
         * 3
         */
        String THREE = "3";

        /**
         * 4
         */
        String FOUR = "4";

        /**
         * 5
         */
        String FIVE = "5";

        /**
         * 6
         */
        String SIX = "6";

        /**
         * 7
         */
        String SEVEN = "7";

        /**
         * 8
         */
        String EIGHT = "8";

        /**
         * 9
         */
        String NINE = "9";

        /**
         * 10
         */
        String TEN = "10";

        /**
         * 查询接口返回数据的list字符串常量
         */
        String LIST = "list";

        /**
         * 登录类型 WEB
         */
        String WEB = "WEB";

        /**
         * 登录类型 CONFERENCEID
         */
        String CONFERENCEID = "CONFERENCEID";

        String SUCCESS = "Success";

        String FAILED = "failed";
    }
}
