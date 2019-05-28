package com.ofme.blog.base.controller;

import com.ofme.blog.base.http.ResponseModel;
import com.ofme.blog.base.http.ResponseStatus;

/**
 * Controller基类
 */
public class BaseController {

    /**
     * 设置请求成功的响应体
     * @param o
     * @return
     */
    public ResponseModel setSuccessModel(Object o){
        ResponseModel model = new ResponseModel();
        model.setResultCode(ResponseStatus.success.getCode());
        model.setResultMessage(ResponseStatus.success.getMessage());
        model.setData(o);
        return model;
    }

    /**
     * 设置请求失败的响应体
     * @param o
     * @return
     */
    public ResponseModel setFailModel(Object o){
        ResponseModel model = new ResponseModel();
        model.setResultCode(ResponseStatus.fail.getCode());
        model.setResultMessage(ResponseStatus.fail.getMessage());
        model.setData(o);
        return model;
    }


}
