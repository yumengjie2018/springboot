package com.boco.jlappservice.aspect;

import com.boco.jlappservice.entity.response.ResponseMessage2;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * title：HttpAspect
 * description:
 *
 * @author yumengjie
 * @date 2019/3/13 10:26
 */
@Aspect
@Component
@Slf4j
public class HttpAspect {
    @Pointcut("execution(public * com.boco.jlappservice.controller.*.*(..))")
    public void log(){

    }
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes=(ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request= attributes.getRequest();
        //url
        log.info("url={}",request.getRequestURI())  ;
        //method
        log.info("method={}",request.getMethod());
        //访问者ip
        log.info("ip={}",request.getRemoteAddr());
        //类方法
        log.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        //参数
        log.info("args={}",joinPoint.getArgs());
    }
    @After("log()")
    public void doAfter(){
    }
    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturning(Object object){
        log.info("response={}", ResponseMessage2.Success2(object.toString()));
    }
    //后置异常通知
    @AfterThrowing(value = "log()",throwing = "e")
    public void logException(JoinPoint joinPoint,Exception e){
        String className = joinPoint.getSignature().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        log.error("类："+className+" -方法："+methodName+"",e);
    }
}