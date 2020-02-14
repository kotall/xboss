package com.github.kotall.commons.http;

import lombok.Data;

@Data
public class HttpResult {
    private String code;
    private String msg;
    private Object data;

    public HttpResult() {
    }

    public HttpResult(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public HttpResult(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public HttpResult(Object data) {
        this.code = "200";
        this.msg = "success";
        this.data = data;
    }


}
