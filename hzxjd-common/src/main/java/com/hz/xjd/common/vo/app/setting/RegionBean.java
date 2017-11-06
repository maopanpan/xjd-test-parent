package com.hz.xjd.common.vo.app.setting;

import com.alibaba.fastjson.JSON;
import com.hz.xjd.common.model.BaseReq;
import org.hibernate.validator.constraints.NotBlank;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Author: maopanpan
 * @Description: 区域定义
 * @Date: 2017/11/03.
 **/
@XmlRootElement
public class RegionBean extends BaseReq {

    @NotBlank
    private String pCode;

    public String getpCode() {
        return pCode;
    }

    public void setpCode(String pCode) {
        this.pCode = pCode;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
