/*
 * 文 件 名:  BasePageReq.java
 * 版    权:  © 2013 dimeng. All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  huanggang
 * 修改时间:  2014-2-13
 */
package com.hz.xjd.common.model;

import com.alibaba.fastjson.JSONObject;

import javax.validation.constraints.Min;

/**
 * 公用分页参数，有分页的继承
 * <功能详细描述>
 *
 * @author  005818
 * @version  [版本号, 2012-12-4]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class BasePageReq extends BaseReq
{
    /**
     * 数据分页页码，不传该参数默认为第一页
     */
    @Min(1)
    private int reqPageNum = 1;

    /**
     * 每页显示的最大数据条数，系统默认为10条
     */
    @Min(1)
    private int maxResults = 10;

    /**
     * @return 返回 reqPageNum
     */
    public int getReqPageNum()
    {
        return reqPageNum;
    }

    /**
     * @param reqPageNum 对reqPageNum进行赋值
     */
    public void setReqPageNum(int reqPageNum)
    {
        this.reqPageNum = reqPageNum;
    }

    /**
     * @return 返回 maxResults
     */
    public int getMaxResults()
    {
        return maxResults;
    }

    /**
     * @param maxResults 对maxResults进行赋值
     */
    public void setMaxResults(int maxResults)
    {
        this.maxResults = maxResults;
    }

    @Override
    public String toString()
    {
        return JSONObject.toJSONString(this);
    }

}
