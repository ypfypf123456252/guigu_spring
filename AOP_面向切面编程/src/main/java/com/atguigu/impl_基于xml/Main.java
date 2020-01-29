package com.atguigu.impl_基于xml;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    @Test
    public void test01(){
        //1.创建spring的IOC容器
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("com/atguigu/impl_基于xml/aop02.xml");
        //2.从IOC容器中获取bean的实例
        ArithmeticCalculator calculator= (ArithmeticCalculator) applicationContext.getBean("arithmeticCalculator");
        //3.使用bean
        int result1 = calculator.add(3, 6);
        System.out.println("result1="+result1);

        int result2=calculator.div(1000,10);
        System.out.println("result2="+result2);
    }
}
