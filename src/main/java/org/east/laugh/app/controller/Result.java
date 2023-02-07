package org.east.laugh.app.controller;

import javax.sound.sampled.DataLine;

public class Result <T>{
    T data;
    Integer code;
    String msg;

    public static final Result<Object> FailResult = new Result<>(null,Code.UNKNOWN_ERR,"出错了!");

    public Result(T data) {
        this.data= data;
        this.code=Code.UNKNOWN_OK;
        this.msg="Look above!缺省！";   //这里有时候会乱码，
    }

    public Result(String msg) {
        this.msg = msg;
        this.code= Code.UNKNOWN_ERR;
    }

    public Result(T data, String msg) {
        this.data= data;
        this.code=Code.UNKNOWN_OK;
        this.msg=msg;
    }

    @Override
    public String toString() {
        return "Result{" +
                "data=" + data +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Result(T data, Integer code, String msg) {
        this.data = data;
        this.code = code;
        this.msg = msg;
    }

    public Result() {
        this.data = null;
        this.code = null;
        this.msg = "服务器未返回任何信息。";
    }
}
