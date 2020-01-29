package 泛型依赖注入;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("泛型依赖注入/beans-generic.xml");

        UserService userService= (UserService) applicationContext.getBean("userService");
        userService.add();

    }
}
