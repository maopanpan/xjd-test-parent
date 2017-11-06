package com.hz.xjd.app.exception;

import org.springframework.core.convert.converter.Converter;

import java.lang.reflect.Array;

/**
 * @Author: maopanpan
 * @Description:
 * @Date: 2017/11/02.
 **/
public class StringToEnumConverter implements Converter<String, Array>{
    @Override
    public Array convert(String source) {
        return null;
    }
}
