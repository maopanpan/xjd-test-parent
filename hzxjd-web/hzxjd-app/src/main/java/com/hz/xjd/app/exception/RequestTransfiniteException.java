package com.hz.xjd.app.exception;

/**
 * @Author: maopanpan
 * @Description: 单位时间请求次数超限
 * @Date: 2017/11/02.
 **/
public class RequestTransfiniteException extends Exception {

    public RequestTransfiniteException() {
        super();
    }

    public RequestTransfiniteException(String message) {
        super(message);
    }
}
