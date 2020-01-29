package com.atguigu.helloworld;

import org.junit.Test;

public class Main {
    @Test
    public void test01(){
        ArithmeticCalculator target=new ArithmeticCalculatorImpl();
        ArithmeticCalculator proxy=new ArithmeticCalculatorLoggingProxy(target).getLoggingProxy();
        int result = proxy.add(1, 2);
        System.out.println(result);
    }
}
