/*
 * 文 件 名:  ServicesException.java
 * 版    权:  © 2013 dimeng. All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  huanggang
 * 修改时间:  2014-2-4

 */
package com.hz.xjd.app.exception;


import com.hz.xjd.common.constants.IResultsCode;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author huanggang
 * @version [版本号, 2014年2月24日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class ServicesException extends Exception
{
    /**
     * 注释内容
     */
    private static final long serialVersionUID = -6137067991428578374L;

    private IResultsCode resultCode;

    public ServicesException(IResultsCode resultCode)
    {
        this.resultCode = resultCode;
    }

    /**
     * @return 返回 resultCode
     */
    public IResultsCode getResultCode()
    {
        return resultCode;
    }

    /**
     * @param resultCode 对resultCode进行赋值
     */
    public void setResultCode(IResultsCode resultCode)
    {
        this.resultCode = resultCode;
    }

}