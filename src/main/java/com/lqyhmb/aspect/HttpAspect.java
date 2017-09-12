package com.lqyhmb.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Rodriguez
 * 2017/9/8 15:01
 */

@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    // 定义公用方法
    @Pointcut("execution(public * com.lqyhmb.controller.GirlController.*(..))")
    public void log() {
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        //System.out.println(111111111);
        //LOGGER.info("111111111");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 请求url
        logger.info("url={}", request.getRequestURL());

        // 请求method
        logger.info("method={}", request.getMethod());

        // 客户端ip
        logger.info("ip={}", request.getRemoteAddr());

        // 类方法
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName()
                + "." + joinPoint.getSignature().getName());

        // 参数
        logger.info("args={}", joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter() {
        //System.out.println(222222222);
        logger.info("222222222");
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
        logger.info("response={}", object.toString());
    }

}
