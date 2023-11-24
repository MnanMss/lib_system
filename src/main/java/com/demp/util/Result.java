package com.demp.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class Result<T>{
    private String code;

    private String msg;

    private T data;

    public Result(T data) {
        this.data = data;
    }

    public static Result<?> success() {
        Result<?> result = new Result<>();
        result.setCode("0");
        result.setMsg("成功");
        return result;
    }

    public static<T> Result<T> success(T data) {
        Result<T> result = new Result<T>(data);
        result.setCode("0");
        result.setMsg("成功");
        return result;
    }


    public static Result<?> error(String code , String msg) {
        Result<?> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
