package com.hz.xjd.app.utils;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;

/**
 * @Author: maopanpan
 * @Description: 全局请求参数解密
 * @Date: 2017/11/01.
 **/
@ControllerAdvice
public class XjdRequestBodyAdvice implements RequestBodyAdvice {

    private Logger logger = LoggerFactory.getLogger(XjdRequestBodyAdvice.class);

    /**
     * 3DES解密密钥
     */
    @Value("${3des.secret.key}")
    private String _3DES_SECRET_KEY;

    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object handleEmptyBody(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return body;
    }

    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) throws IOException {
        try {
            return new XjdHttpInputMessage(inputMessage);
        } catch (Exception e) {
            logger.error("【全局】请求参数解密异常", e);
            return null;
        }
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return body;
    }


    /**
     * 对请求数据进行加密处理
     */
    class XjdHttpInputMessage implements HttpInputMessage {
        private HttpHeaders headers;

        private InputStream body;

        public XjdHttpInputMessage(HttpInputMessage inputMessage) throws Exception {
            this.headers = inputMessage.getHeaders();
            String data = IOUtils.toString(inputMessage.getBody(), "UTF-8");
            this.body = IOUtils.toInputStream(DES3Util.decryptMode(data, _3DES_SECRET_KEY), "UTF-8");
        }

        @Override
        public InputStream getBody() throws IOException {
            return body;
        }

        @Override
        public HttpHeaders getHeaders() {
            return headers;
        }
    }

}
