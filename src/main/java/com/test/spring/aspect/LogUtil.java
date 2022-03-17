package com.test.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogUtil {

    @Pointcut("execution(public * com.test.spring.service.impl.*.*(..))")
    public void pointCut(){ }

    @Before("pointCut()")
    public void beforeMethod(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        String name = joinPoint.getSignature().getName();
        System.out.println("方法前");
    }

    @After("execution(public * com.test.spring.service.impl.*.*(..))")
    public void afterMethod(){
        System.out.println("方法后");
    }

    @AfterThrowing(value = "execution(public * com.test.spring.service.impl.*.*(..))", throwing = "exception")
    public void throwMethod(Exception exception){
        System.out.println("方法异常后");
    }

    @AfterReturning(value = "execution(public * com.test.spring.service.impl.*.*(..))", returning = "returnValue")
    public void returnMethod(Object returnValue){
        System.out.println("方法返回");
    }
}
