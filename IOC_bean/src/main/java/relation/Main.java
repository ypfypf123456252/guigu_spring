package relation;

import autowire_自动装配.Address;
import autowire_自动装配.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("relation/beans-relation.xml");

//        Address address= (Address) applicationContext.getBean("address");
//        System.out.println(address);

        Address address2= (Address) applicationContext.getBean("address2");
        System.out.println(address2);

        Person person= (Person) applicationContext.getBean("person");
        System.out.println(person);
    }
}
