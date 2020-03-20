package com.fwh.blog.aspect;

import java.util.Arrays;

// 把日志所记录的内容封装成一个类
public class RequestLog {
    // 请求url
    private String url;
    // 访问者ip
    private String ip;
    // 调用方法classMethod
    private String classMethod;
    // 请求的参数 args
    private Object[] args;

    public RequestLog(String url, String ip, String classMethod, Object[] args) {
        this.url = url;
        this.ip = ip;
        this.classMethod = classMethod;
        this.args = args;
    }

    @Override
    public String toString() {
        return "{" +
                "url='" + url + '\'' +
                ", ip='" + ip + '\'' +
                ", classMethod='" + classMethod + '\'' +
                ", args=" + Arrays.toString(args) +
                '}';
    }
}
