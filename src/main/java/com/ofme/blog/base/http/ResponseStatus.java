package com.ofme.blog.base.http;

public enum ResponseStatus {

    success(200,"请求成功!"),
    fail(500,"请求失败!");

    private Integer code;

    private String message;


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    ResponseStatus(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
