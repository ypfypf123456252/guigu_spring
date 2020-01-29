package com.atguigu.impl_基于注解;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;


/**
 * Order:指定优先级,值越小,优先级越高
 */
@Order(1)
@Aspect
@Component

public class VlidationAspect {
//    @Before("execution(public int com.atguigu.impl.ArithmeticCalculator.*(int  ,int ))")
    @Before("com.atguigu.impl_基于注解.LoggingAspect.declareJoinPointExpression()")
    public void validateArgs(JoinPoint joinPoint){
        System.out.println("validate:"+ Arrays.asList(joinPoint.getArgs()));
    }
}
