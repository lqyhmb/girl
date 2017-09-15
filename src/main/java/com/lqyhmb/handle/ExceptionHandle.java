package com.lqyhmb.handle;

import com.lqyhmb.exception.GirlException;
import com.lqyhmb.model.Result;
import com.lqyhmb.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by Rodriguez
 * 2017/9/15 12:46
 */

@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class) //声明要捕获的异常类
    @ResponseBody // 声明返回json格式数据
    public Result handle(Exception e) {
        if (e instanceof GirlException) { // 判断当前捕获的是否是自定义异常
            GirlException girlException = (GirlException) e;
            return ResultUtil.error(girlException.getCode(), girlException.getMessage());
        } else {
            logger.error("[系统异常] {}", e);
            return ResultUtil.error(-1, "未知错误");
        }
    }

}
