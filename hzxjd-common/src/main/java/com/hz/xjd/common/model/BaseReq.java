/*
 * 文 件 名:  BaseReq.java
 * 版    权:  © 2014 dimeng. All rights reserved.
 * 描    述:  <描述>
 * 修 改 人:   huanggang
 * 修改时间:  2013-11-4
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.hz.xjd.common.model;

import com.alibaba.fastjson.JSONObject;
import com.hz.xjd.common.enu.Terminal;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 接口请求基类
 * 所有接口入口参数都继承这个类
 *
 * @author  huanggang
 * @version  [版本号, 2013-11-4]
 */
@XmlRootElement
public class BaseReq
{
    /**
     * 手持设备唯一标示
     */
    private String imei;

    /**
     * 操作来源 pc:前端，ad:安卓，ios:苹果,other:其他
     */
    @NotBlank
    @Pattern(regexp = "pc|ad|ios|wx|other")
    private String opSource = "pc";

    private String version = "0";

    public String getImei()
    {
        return imei;
    }

    public void setImei(String imei)
    {
        this.imei = imei;
    }

    public String getOpSource()
    {
        return opSource;
    }

    public void setOpSource(String opSource)
    {
        this.opSource = opSource;
    }

    public String getVersion()
    {
        return version;
    }

    public void setVersion(String version)
    {
        this.version = version;
    }

    /**
     * 得到属性字符串
     * @return String 属性字符串
     */
    @Override
    public String toString()
    {
        return JSONObject.toJSONString(this);
    }

    /**
     * 获取终端类型
     * <功能详细描述>
     * @return
     */
    public Terminal getTerminal()
    {
        if ("ios".equals(opSource))
        {
            return Terminal.ios;
        }
        if ("ad".equals(opSource))
        {
            return Terminal.ad;
        }
        if ("pc".equals(opSource))
        {
            return Terminal.pc;
        }
        if ("wx".equals(opSource))
        {
            return Terminal.wx;
        }
        return Terminal.other;
    }
}