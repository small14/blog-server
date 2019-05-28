package com.ofme.blog;

import com.ofme.blog.base.exception.OFMException;
import com.ofme.blog.base.http.ResponseModel;
import com.ofme.blog.base.http.ResponseStatus;
import org.apache.shiro.authz.UnauthenticatedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author y14
 * @date 2019-05-23
 * 全局异常处理器
 */
@ControllerAdvice
public class GlobalDefultExceptionHandler {

    @ExceptionHandler
    @ResponseBody
    public ResponseModel defultExceptionHandler(HttpServletRequest request, Exception e){


        ResponseModel responseModel = new ResponseModel();
        responseModel.setResultCode(ResponseStatus.fail.getCode());
        responseModel.setResultMessage(ResponseStatus.fail.getMessage());
        Map<String,String> erroMessage = new HashMap<>();
        erroMessage.put("error","程序出现异常，请稍后再试");
        responseModel.setData(erroMessage);

        /**
         * shiro异常 权限不足
         */
        if (e instanceof UnauthenticatedException){
            erroMessage.put("error","您的权限不足！");
        }else if (e instanceof OFMException){
            erroMessage.put("error",e.getMessage());
        }
        return responseModel;
    }
}
