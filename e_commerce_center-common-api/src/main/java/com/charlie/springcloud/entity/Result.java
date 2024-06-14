package com.charlie.springcloud.entity;

public class Result<T> {

    private String code;    // 状态码
    private String msg;     // 状态说明
    private T data;         // 返回时携带的数据，使用泛型便于扩展

    public Result() {}      // 无参构造器

    // 带参构造器，指定返回的data
    public Result(T data) {
        this.data = data;
    }

    // 返回表示成功的Result对象，不懈怠数据
    public static Result success() {
        Result<Object> result = new Result<>();
        result.setCode("200");
        result.setMsg("success");
        return result;
    }

    // 返回表示成功的Result对象，同时携带数据
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>(data);
        result.setCode("200");
        result.setMsg("success");
        return result;
    }

    // 返回表示成功的Result对象，同时携带数据和信息
    public static <T> Result<T> success(String msg, T data) {
        Result<T> result = new Result<>(data);
        result.setCode("200");
        result.setMsg(msg);
        return result;
    }

    // 返回表示失败的Result对象，不携带数据
    public static Result error(String code, String msg) {
        Result<Object> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
