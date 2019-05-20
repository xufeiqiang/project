package com.cn.betasoft.redis.model;

/**
 * Created by ZC-16-012 on 2018/8/1.
 */


public class Response {

    private boolean status;

    private String msg;

    public Response(boolean status,String msg){
        this.status= status;
        this.msg =msg;
    }

   public Response(){}

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
