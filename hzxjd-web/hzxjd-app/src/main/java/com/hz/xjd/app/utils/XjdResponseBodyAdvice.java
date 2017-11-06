package com.hz.xjd.app.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hz.xjd.app.annotation.DES3;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @Author: maopanpan
 * @Description: 全部响应数据加密
 * @Date: 2017/11/01.
 **/
@ControllerAdvice
public class XjdResponseBodyAdvice implements ResponseBodyAdvice {

    private Logger logger = LoggerFactory.getLogger(XjdRequestBodyAdvice.class);

    /**
     * 3DES加密密钥
     */
    @Value("${3des.secret.key}")
    private String _3DES_SECRET_KEY;

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        //默认加密
        boolean encrypt = true;
        if (returnType.getMethod().isAnnotationPresent(DES3.class)) {
            //获取注解配置的包含和去除字段
            DES3 des3 = returnType.getMethodAnnotation(DES3.class);
            //是否加密
            encrypt = des3.isEncrypt();
        }

        if (encrypt) {
            try {
                MappingJacksonValue mappingJacksonValue = (MappingJacksonValue) body;
                ObjectMapper objectMapper = new ObjectMapper();
                String result = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(mappingJacksonValue.getValue());
                return DES3Util.encryptMode(result, _3DES_SECRET_KEY);
            } catch (JsonProcessingException e) {
                // TODO Auto-generated catch block
                logger.error("【全局】响应参数加密异常", e);
                return null;
            }
        }

        return body;
    }
}
