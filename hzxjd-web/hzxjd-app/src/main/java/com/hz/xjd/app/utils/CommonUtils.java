/*
 * 文 件 名:  CommonUtils.java
 *
 * 描    述:  <描述>
 * 修 改 人:  tonglei
 * 修改时间:  2015/7/3
 */
package com.hz.xjd.app.utils;

import com.hz.xjd.common.utils.SystemConfig;

/**
 * 功能详细描述
 *
 * @author tonglei
 * @version [版本号, 2015/7/3]
 */
public class CommonUtils
{

    /**
     * 获取文件上传地址
     * @return String 上传文件路径
     */
    public static String getFileUploadRoot()
    {
        //文件地址
        String root = SystemConfig.getProperty("web.upload.path");
        if (root == null || root.trim().length() == 0)
        {
            root = SystemConfig.getProperty("web.site.domain");
        }
        return root;
    }

    /**
     * 根据终端获取类型
     * <功能详细描述>
     * @param opSource
     * @return
     */
    public static String getTerminalByOpSource(String opSource){
        if("ad".equals(opSource)||"ios".equals(opSource)||"wx".equals(opSource)){
            return "app";
        }else if("pc".equals(opSource)){
            return "pc";
        }else{
            return "other";
        }
    }
}
