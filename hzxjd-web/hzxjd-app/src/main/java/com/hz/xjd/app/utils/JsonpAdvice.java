/*
 * 文 件 名:  JsonpAdvice.java
 *
 * 描    述:  <描述>
 * 修 改 人:  huanggang
 * 修改时间:  2015年6月2日
 */
package com.hz.xjd.app.utils;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

/**
 * 提供对JSONP的支持
 * <功能详细描述>
 *
 * @author  huanggang
 * @version  [版本号, 2015年6月2日]
 */
@ControllerAdvice
public class JsonpAdvice extends AbstractJsonpResponseBodyAdvice
{
    public JsonpAdvice()
    {
        super("callback");
    }
}
