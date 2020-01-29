package beans;

import collection.DataSource;
import collection.PersonList;
import collection.PersonMap;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    @Test
    public void test01(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("beans/bean01.xml");
        HelloWorld helloWorld = (HelloWorld) applicationContext.getBean("helloWorld");
        helloWorld.hello();

        Car car = (Car) applicationContext.getBean("car");
        System.out.println(car);

        Car car1= (Car) applicationContext.getBean("car2");
        System.out.println(car1);

        Person person= (Person) applicationContext.getBean("person");
        System.out.println(person);

        Person person2=(Person)applicationContext.getBean("person2");
        System.out.println(person2);

        PersonList person3 = (PersonList) applicationContext.getBean("person3");
        System.out.println(person3);

        PersonMap personMap = (PersonMap) applicationContext.getBean("personMap");
        System.out.println(personMap);

        DataSource dataSource=applicationContext.getBean(DataSource.class);
        System.out.println(dataSource.getProperties());

        PersonList person4 = (PersonList) applicationContext.getBean("person4");
        System.out.println(person4);

        PersonList person5= (PersonList) applicationContext.getBean("person5");
        System.out.println(person5);
    }
}
