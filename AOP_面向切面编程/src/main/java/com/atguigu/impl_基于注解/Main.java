package com.atguigu.impl_基于注解;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    @Test
    public void test01(){
        //1.创建spring的IOC容器
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("com/atguigu/impl_基于注解/aop01.xml");
        System.out.println(applicationContext.getClass().getName()+"############");
        //2.从IOC容器中获取bean的实例
        ArithmeticCalculator calculator=applicationContext.getBean(ArithmeticCalculator.class);
        System.out.println(calculator.getClass().getName()+"*****");
        //3.使用bean
        int result = calculator.add(3, 6);
        System.out.println("result="+result);
    }
}
