package com.hz.xjd.app.exception;

import com.hz.xjd.app.utils.DES3Util;
import com.hz.xjd.common.constants.IResultsCode;
import com.hz.xjd.common.model.BaseResp;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class ExceptionHandler implements HandlerExceptionResolver
{
    private static final Log logs = LogFactory.getLog(ExceptionHandler.class);

    @Value("${3des.secret.key}")
    private String _3DES_SECRET_KEY;

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object obj,
        Exception exception)
    {
        BaseResp baseResp = new BaseResp();
        if (ServicesException.class.isAssignableFrom(exception.getClass()))
        {
            ServicesException se = (ServicesException)exception;
            baseResp.setCode(se.getResultCode());
        }
        else if (UnauthorizedException.class.isAssignableFrom(exception.getClass()))
        {
            baseResp.setCode(IResultsCode.USER_ERROR_USERNAME_NO_PERMISSION);
        }
        else if (MaxUploadSizeExceededException.class.isAssignableFrom(exception.getClass()))
        {
            baseResp.setCode(IResultsCode.ERROR_MAX_UPLOAD_SIZE);
        }
        else if (RequestTransfiniteException.class.isAssignableFrom(exception.getClass()))
        {
            //使用次数超限
            baseResp.setCode(IResultsCode.REQ_TRANS_LIMIT);
        }
        else
        {
            baseResp.setCode(IResultsCode.ERROR_UNKNOWN);
        }
        logs.error("ExceptionHandler.resolveException", exception);
        logs.info("ExceptionHandler.resolveException, baseResp = " + baseResp);
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = null;
        try
        {
            out = response.getWriter();
            out.print(DES3Util.encryptMode(baseResp.toString(), _3DES_SECRET_KEY));
            response.flushBuffer();
        }
        catch (IOException e)
        {
            logs.error("ExceptionHandler.resolveException", e);
        }
        finally
        {
            if (null != out)
            {
                out.close();
            }
        }
        return new ModelAndView();
    }
}
