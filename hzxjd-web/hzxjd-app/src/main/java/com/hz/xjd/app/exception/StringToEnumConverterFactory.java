package com.hz.xjd.app.exception;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

import java.util.List;

/**
 * @Author: maopanpan
 * @Description:
 * @Date: 2017/11/02.
 **/
public class StringToEnumConverterFactory implements ConverterFactory<String, List> {

     @Override
    public <T extends List> Converter<String, T> getConverter(Class<T> targetType) {
        return null;
    }
}
