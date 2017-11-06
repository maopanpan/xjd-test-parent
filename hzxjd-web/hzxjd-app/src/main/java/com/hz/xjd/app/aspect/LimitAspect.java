package com.hz.xjd.app.aspect;


import com.hz.xjd.app.annotation.Limit;
import com.hz.xjd.app.exception.RequestTransfiniteException;
import com.hz.xjd.common.utils.StringUtils;
import com.hz.xjd.manager.RedisManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;

/**
 * @Author: maopanpan
 * @Description: 访问频率控制器
 * @Date: 2017/11/02.
 **/
public class LimitAspect extends HandlerInterceptorAdapter {

    @Autowired
    private RedisManager redisManager;

    private int dbindex = 3;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Limit limit = findAnnotation((HandlerMethod) handler, Limit.class);
        if (limit == null) {
            return true;
        }

        //获取授权TOKEN
        String authentication = ((HttpServletRequest) request).getHeader("Authorization");
        if (!StringUtils.isEmpty(authentication)) {
            //获取请求地址
            String uri = request.getRequestURI();
            //限流地址
            String path = limit.path();
            if (uri.contains(path)) {
                String redisKey = authentication + ":" + path;
                if (redisManager.existsKey(dbindex, redisKey)) {
                    redisManager.incr(dbindex, redisKey);
                    String value = redisManager.get(dbindex, redisKey);
                    long count = Long.parseLong(value);
                    if (count > limit.count()) {
                        throw new RequestTransfiniteException("请求次数超限");
                    }
                } else {
                    //设置key生命周期
                    redisManager.set(dbindex, redisKey, limit.seconds(), 1);
                }
            }
        }


        return true;
    }

    private <T extends Annotation> T findAnnotation(HandlerMethod handler, Class<T> annotationType) {
        T annotation = handler.getBeanType().getAnnotation(annotationType);
        if (annotation != null) return annotation;
        return handler.getMethodAnnotation(annotationType);
    }
}
