package com.hz.xjd.app.annotation;

import org.springframework.web.bind.annotation.Mapping;

import java.lang.annotation.*;

/**
 * @Author: maopanpan
 * @Description: 控制单位时间内访问频率
 * @Date: 2017/11/02.
 **/
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Mapping
public @interface Limit {

    /**
     * 限流路径
     *
     * @return
     */
    String path();

    /**
     * 访问频率（单位：次）
     *
     * @return
     */
    long count() default 5;

    /**
     * 时效（单位：秒）
     *
     * @return
     */
    long seconds() default 60;
}
