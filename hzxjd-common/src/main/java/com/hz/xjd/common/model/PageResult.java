/*
 * 文 件 名:  PageResult.java
 *
 * 描    述:  <描述>
 * 修 改 人:  huanggang
 * 修改时间:  2015年6月2日
 */
package com.hz.xjd.common.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * 返回的分页信息
 */
public class PageResult implements Serializable
{
    /**
     * 注释内容
     */
    private static final long serialVersionUID = 1L;

    /**
     * 总记录数
     */
    private int recordCount;

    /**
     * 当前页
     */
    private int pageIndex;

    /**
     * 页记录数大小
     */
    private int pageSize;

    /**
     * 结果集
     */
    private List<?> list;


    @SuppressWarnings("rawtypes")
    public PageResult(Page page, List<?> list)
    {
        this.recordCount = page.getRowCount();
        this.pageIndex = page.getCurrPage();
        this.pageSize = page.getPageSize();
        this.list = list == null ? new ArrayList() : list;
    }

    public int getRecordCount()
    {
        return recordCount;
    }

    public void setRecordCount(int recordCount)
    {
        this.recordCount = recordCount;
    }

    public int getPageIndex()
    {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex)
    {
        this.pageIndex = pageIndex;
    }

    public int getPageSize()
    {
        return pageSize;
    }

    public void setPageSize(int pageSize)
    {
        this.pageSize = pageSize;
    }

    public List<?> getList()
    {
        return list;
    }

    public void setList(List<?> list)
    {
        this.list = list;
    }

}
