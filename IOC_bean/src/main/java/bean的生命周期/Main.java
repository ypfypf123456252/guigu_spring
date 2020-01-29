package bean的生命周期;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("bean的生命周期/cycle.xml");
        Car car= (Car) applicationContext.getBean("car");
        System.out.println(car);
        //关闭容器
        applicationContext.close();
    }
}
