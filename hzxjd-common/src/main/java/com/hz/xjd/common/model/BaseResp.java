/*
 * 文 件 名:  BaseResp.java
 * 版    权:  © 2014 dimeng. All rights reserved.
 * 描    述:  <描述>
 * 修 改 人:  huanggang
 * 修改时间:  2012-12-5
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.hz.xjd.common.model;

import com.alibaba.fastjson.JSONObject;
import com.hz.xjd.common.constants.IResultsCode;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 返回结果封装基类
 * 所有接口入口参数都继承这个类
 *
 * @author huangang
 * @version [版本号, 2012-12-5]
 */
@XmlRootElement(name = "Resp")
public class BaseResp
{

    /**
     * 返回码，默认成功
     */
    private String code = "-1";

    /**
     * 返回码，默认失败
     */
    private String description = "fail";

    public String getCode()
    {
        return code;
    }

    public void setCode(IResultsCode resultsCode)
    {
        this.code = resultsCode.getKey();
        this.description = resultsCode.getDescription();
    }

    public void setCode(IResultsCode resultsCode, String descr)
    {
        this.code = resultsCode.getKey();
        this.description = descr;
    }

    public String getDescription()
    {
        return description;
    }

    /**
     * 得到属性字符串
     *
     * @return String 属性字符串
     */
    @Override
    public String toString()
    {
        return JSONObject.toJSONString(this);
    }
}
