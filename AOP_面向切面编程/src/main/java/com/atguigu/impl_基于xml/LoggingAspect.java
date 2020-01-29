package com.atguigu.impl_基于xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import java.util.Arrays;
import java.util.List;

public class LoggingAspect {
    public void beforeMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        List<Object> args= Arrays.asList(joinPoint.getArgs());
        System.out.println("The method"+methodName+" begins "+args);
    }

    public void afterMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method "+methodName+" ends");
    }

    public void afterReturning(JoinPoint joinPoint,Object result){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method "+methodName+" ends with "+result);
    }

    public void afterThrowing(JoinPoint joinPoint,Exception ex){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method "+methodName+" occus with "+ex);
    }

    public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint){
        Object result=null;
        String methodName=proceedingJoinPoint.getSignature().getName();
        //执行目标方法
        try {
            //前置通知
            System.out.println("The method "+methodName+"begins with "+Arrays.asList(proceedingJoinPoint.getArgs()));
            result = proceedingJoinPoint.proceed();
            //返回通知
            System.out.println("The method "+methodName+" ends with "+result);
        } catch (Throwable e) {
            //异常通知
            System.out.println("The method "+methodName+"occurs exception:"+e);
            throw new RuntimeException(e);
        }
        //后置通知
        System.out.println("The method "+methodName+"ends");
        return result;
    }
}
