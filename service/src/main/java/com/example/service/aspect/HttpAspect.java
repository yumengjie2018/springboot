package com.example.service.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
//请求每个方法之前在日志里面打印出请求信息（AOP统一处理）
@Aspect
@Component
@Slf4j
public class HttpAspect {
    @Pointcut("execution(public * com.example.service.controller.*.*(..))")
    public void log(){

    }

    //后置异常通知
    @AfterThrowing(value = "log()",throwing = "e")
    public void logException(JoinPoint joinPoint,Exception e){
        String className = joinPoint.getSignature().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        log.error("类："+className+" -方法："+methodName+"",e);
    }
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
//        ServletRequestAttributes
       log.info("11111111111111111");
        ServletRequestAttributes attributes=(ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request= attributes.getRequest();
        //url
        log.info("url={}",request.getRequestURI())  ;
        //method
        log.info("method={}",request.getMethod());
        //ip
        log.info("ip={}",request.getRequestedSessionId());
        //类方法
        log.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        //参数
        log.info("args={}",joinPoint.getArgs());
    }
    @After("log()")
    public void soAfter(){
        log.info("222222222222222222");
    }
    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturning(Object object){
        log.info("response={}",object.toString());
    }
}
