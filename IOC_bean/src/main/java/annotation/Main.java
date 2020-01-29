package annotation;

import annotation.controller.UserController;
import annotation.repository.UserRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("annotation/beans-annotation.xml");

        UserController userController= (UserController) applicationContext.getBean("userController");
        System.out.println(userController);
        userController.execute();

//        UserRepository userRepository= (UserRepository) applicationContext.getBean("userRepositoryImpl");
//        System.out.println(userRepository);
    }
}
