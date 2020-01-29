package com.事务xml形式;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.Arrays;

public class Main {
    private ApplicationContext applicationContext=new ClassPathXmlApplicationContext("bean02.xml");

    private Cashier cashier= (Cashier) applicationContext.getBean("cashier");
    @Test
    public void testTransactionalPropagation() throws Exception {
        cashier.checkout("AA", Arrays.asList("1001","1002"));
    }
}
