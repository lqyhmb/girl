package com.lqyhmb.utils;

import com.lqyhmb.model.Result;

/**
 * Created by Rodriguez
 * 2017/9/12 13:54
 */
public class ResultUtil {

    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static Result error(Integer code, String message) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(message);
        result.setData(null);
        return result;
    }

}
