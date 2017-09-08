package com.lqyhmb.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by Rodriguez
 * 2017/9/8 15:01
 */

@Aspect
@Component
public class HttpAspect {

    private final static Logger LOGGER = LoggerFactory.getLogger(HttpAspect.class);

    // 定义公用方法
    @Pointcut("execution(public * com.lqyhmb.controller.GirlController.*(..))")
    public void log() {
    }

    @Before("log()")
    public void doBefore() {
        //System.out.println(111111111);
        //LOGGER.info("111111111");

        //ServletRequestContextHolder
        // 请求url

        // 请求method

        // 客户端ip

        // 类方法

        // 参数
    }

    @After("log()")
    public void doAfter() {
        //System.out.println(222222222);
        LOGGER.info("222222222");
    }
}
