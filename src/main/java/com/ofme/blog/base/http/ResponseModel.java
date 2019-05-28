package com.ofme.blog.base.http;


import lombok.Data;

import java.util.Date;

@Data
public class ResponseModel {

    private int resultCode;

    private String resultMessage;

    private Object data;

    private long timestamp;

    public ResponseModel() {
        this.timestamp = new Date().getTime();
    }
}
