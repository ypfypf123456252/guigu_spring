package autowire_自动装配;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("autowire_自动装配/beans-autowire.xml");
        Person person= (Person) applicationContext.getBean("person");
        System.out.println(person);
    }
}
