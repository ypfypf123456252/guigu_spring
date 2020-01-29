package com.事务;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class Main {
    private ApplicationContext applicationContext=new ClassPathXmlApplicationContext("bean01.xml");
    private BookShopDao bookShopDao=applicationContext.getBean(BookShopDao.class);
    private BookShopService bookShopService=applicationContext.getBean(BookShopService.class);
    @Test
    public void testBookShopDaoFindPriceByIsbn(){
        System.out.println(bookShopDao.findBookPriceByIsbn("1001"));
    }
    @Test
    public void testUpdateBookStock() throws Exception {
        bookShopDao.updateBookStock("1001");
    }
    @Test
    public void testUpdateUserAccount() throws Exception {
        bookShopDao.updateUserAccount("AA",100);
    }

    @Test
    public void testBookShopService() throws Exception {
        bookShopService.purchase("AA","1001");
    }

    private Cashier cashier= (Cashier) applicationContext.getBean("cashier");
    @Test
    public void testTransactionalPropagation() throws Exception {
        cashier.checkout("AA", Arrays.asList("1001","1002"));
    }
}
