package com.hz.xjd.common.model;

import com.alibaba.fastjson.JSONObject;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Resp")
@XmlAccessorType(XmlAccessType.FIELD)
public class BaseDataResp extends BaseResp
{

    private Object data;

    public Object getData()
    {
        return data;
    }

    public void setData(Object data)
    {
            this.data = data;

    }

    @Override
    public String toString()
    {
        return JSONObject.toJSONString(this);
    }

}
