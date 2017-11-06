package com.hz.xjd.common.utils;

import java.util.HashMap;
import java.util.Map;

import com.hz.xjd.common.enu.MethodType;

public class Parameter {

    private MethodType type;

    private Map<String, String> data;

    /**
     * 设置参数
     * @param paramName 参数名
     * @param value 参数值
     */
    public void setParamPair(String paramName, String value){
        if(data == null)
            data = new HashMap<String,String>();
        data.put(paramName, value);
    }

    public Map<String,String> getData() {
        return data;
    }

    /**
     * POST/GET
     * @param type
     */
    public void setType(MethodType type) {
        this.type = type;
    }

    public MethodType getType() {
        return type;
    }

    @Override
    public String toString() {
        return data.toString();
    }

}
