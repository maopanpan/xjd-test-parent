package com.hz.xjd.common.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hz.xjd.common.model.Result;


/**
 * 接口返回map组装类
 */
public class MapUtil {


    private final static Logger logger = LoggerFactory.getLogger(MapUtil.class);

    private static final String SEP1 = ":";
    private static final String SEP2 = ",";
    private static final String SEP3 = "{";
    private static final String SEP4 = "}";


    /**
     * 接口返回map组装类
     * <功能详细描述>
     * @param resCode 返回code
     * @param msg     返回错误信息
     * @param data    返回数据
     * @return Map
     */
    public static Map<String, Object> assembleResMap(Result res){
        Map<String, Object> resMap = new HashMap<String, Object>();
        resMap.put("code", res.getCode());
        resMap.put("msg", res.getMsg());
        resMap.put("data", res.getData());
        return resMap;
    }


    /**
     * 打印接口参数传递日志，把map转为Str
     * <功能详细描述>
     * @param map
     * @return String
     */
    @SuppressWarnings("rawtypes")
    public static String mapToStr(Map<?, ?> map){
        java.util.Map.Entry entry;
        StringBuffer sb = new StringBuffer();
        sb.append(SEP3);
        for(Iterator iterator = map.entrySet().iterator(); iterator.hasNext();)
        {
          entry = (java.util.Map.Entry)iterator.next();
            sb.append(entry.getKey().toString()).append( SEP1 ).append(null==entry.getValue()?"":
            entry.getValue().toString()).append (iterator.hasNext() ? SEP2 : "");
        }
        sb.append(SEP4);
        return sb.toString();
    }

    /**
     * 把List转为String
     * 此功能只能把List中的List和Map、基本类型转为String
     * @param list
     * @return
     */
    public static String listToString(List<?> list) {
        StringBuffer sb = new StringBuffer();
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) == null || list.get(i).equals("")) {
                    continue;
                }
                // 如果值是list类型则调用自己
                if (list.get(i) instanceof List) {
                    sb.append(listToString((List<?>) list.get(i)));
                    sb.append(SEP1);
                } else if (list.get(i) instanceof Map) {
                    sb.append(mapToStr((Map<?, ?>) list.get(i)));
                    sb.append(SEP1);
                } else {
                    sb.append(list.get(i));
                    sb.append(SEP1);
                }
            }
        }
        return sb.toString();
    }

    /**
     * 判断字符串是否为1开头的数字
     * 先判断是否为null,再判断是否为1开头的数字
     * @param str
     * @return
     */
    public static boolean isNum(String str){
        if(StringUtils.isEmpty(str)){
            return false;
        }
        return str.matches("^1[0-9]*");
    }

    /**
     * 把一个map转换为bean
     * 传一个map对象 和一个  new Obj对象   转换为Obj的对象
     * @param map
     * @param obj
     */
    public static void transMapToBean(Map<String, Object> map, Object obj) {
        // Map --> Bean 1: 利用Introspector,PropertyDescriptor实现 Map --> Bean
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();
                if (map.containsKey(key)) {
                    Object value = map.get(key);
                    // 得到property对应的setter方法
                    Method setter = property.getWriteMethod();
                    setter.invoke(obj, value);
                }
            }
        } catch (Exception e) {
            logger.error("MapTobean转化错误。请检查参数是否正确", e);
        }

        return;

    }

    /**
     * 方法名称:transMapToString
     * 传入参数:map
     * 返回值:String 形如 {username:chenziwen,Password:1234}
     * @author tangxianjie
     * @date 2015.2.2
    */
    @SuppressWarnings("rawtypes")
    public static String transMapToString(Map map){
      java.util.Map.Entry entry;
      StringBuffer sb = new StringBuffer();
      sb.append(SEP3);
      for(Iterator iterator = map.entrySet().iterator(); iterator.hasNext();)
      {
        entry = (java.util.Map.Entry)iterator.next();
          sb.append(entry.getKey().toString()).append( SEP1 ).append(null==entry.getValue()?"":
          entry.getValue().toString()).append (iterator.hasNext() ? SEP2 : "");
      }
      sb.append(SEP4);
      return sb.toString();
    }



    /**
     * 反射map
     * <功能详细描述>
     * @param map
     * @param cla
     * @return
     * @throws Exception
     * @throws SecurityException
     */
    public static Object mapToBean(Map<String, Object> map, Class<?> cla) throws InstantiationException, Exception {
        if (map == null)
            return null;
        Method method = null;
        Object obj = cla.newInstance();
        Field fil = null;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String filed = entry.getKey();
            fil = cla.getDeclaredField(filed);
            if (fil == null)
                continue;
            method = cla.getMethod("set" + filed.substring(0, 1).toUpperCase() + filed.substring(1), fil.getType());
            if (method == null)
                continue;
            method.invoke(obj, entry.getValue());
        }
        return obj;
    }
}
