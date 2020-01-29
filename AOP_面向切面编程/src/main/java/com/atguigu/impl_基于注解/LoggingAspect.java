package com.atguigu.impl_基于注解;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

//把这个类声明为一个切面:需要把该类放入到IOC容器中,再声明为一个切面
@Order(2)
@Aspect
@Component
public class LoggingAspect {
    /**
     * 声明一个方法,用于声明切入点表达式.一般的,该方法中再不需要添加其他代码
     * 使用 @Pointcut 来声明切入点表达式
     * 后面的其他通知直接使用方法名来引用当前的切入点表达式
     */
    @Pointcut("execution(public int com.atguigu.impl_基于注解.ArithmeticCalculator.*(int  ,int ))")
    public void declareJoinPointExpression(){}
    /**
     * 前置通知:
     * 声明该方法是一个前置通知:在目标方法开始之前执行
     */
//    @Before("execution(public int com.atguigu.impl.ArithmeticCalculator.*(int  ,int ))")
    @Before("declareJoinPointExpression()")
    public void beforeMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        List<Object> args= Arrays.asList(joinPoint.getArgs());
        System.out.println("The method"+methodName+" begins "+args);
    }

    /**
     * 后置通知:
     * 在目标方法执行后(无论是否发生异常),执行的通知
     * 在后置通知中还不能访问目标方法执行的结果
     */
//    @After("execution(public int com.atguigu.impl.ArithmeticCalculator.*(int  ,int ))")
    @After("declareJoinPointExpression()")
    public void afterMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method "+methodName+" ends");
    }

    /**
     * 返回通知:
     * 在方法正常结束执行的代码
     * 返回通知可以访问到方法的返回值
     */
//    @AfterReturning(value = "execution(public int com.atguigu.impl.ArithmeticCalculator.*(..))",returning = "result")
    @AfterReturning(value = "declareJoinPointExpression()",returning = "result")
    public void afterReturning(JoinPoint joinPoint,Object result){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method "+methodName+" ends with "+result);
    }

    /**
     * 异常通知
     */
//    @AfterThrowing(value = "execution(public int com.atguigu.impl.ArithmeticCalculator.*(..))",throwing = "ex")
    @AfterThrowing(value = "declareJoinPointExpression()",throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint,Exception ex){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method "+methodName+" occus with "+ex);
    }

    /**
     * 环绕通知:
     *  需要携带 ProceedingJoinPoint 类型的参数
     *  环绕通知类似于动态代理的全过程: ProceedingJoinPoint 类型的参数可以决定是否执行目标方法
     *  且环绕通知必须有返回值,返回值即为目标方法的返回值
     */
//    @Around("execution(public int com.atguigu.impl.ArithmeticCalculator.*(..))")
    @Around("declareJoinPointExpression()")
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
