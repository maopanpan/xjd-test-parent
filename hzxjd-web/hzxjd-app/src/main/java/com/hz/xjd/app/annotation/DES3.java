package com.hz.xjd.app.annotation;

import org.springframework.web.bind.annotation.Mapping;

import java.lang.annotation.*;

/**
 * @Author: maopanpan
 * @Description: 用于标注响应参数是否加密（系统默认加密）
 * @Date: 2017/11/01.
 **/
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Mapping
public @interface DES3 {

    /**
     * 是否加密，默认为FALSE
     *
     * @return
     */
    boolean isEncrypt() default false;
}
