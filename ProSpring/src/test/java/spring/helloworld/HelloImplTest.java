package spring.helloworld;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.helloworld.ioc.base.HelloApi;

public class HelloImplTest {
    @Test
    public void testHelloWorld(){
//        ApplicationContext context = new ClassPathXmlApplicationContext("helloworld.xml");

        ApplicationContext context = new ClassPathXmlApplicationContext("namingbean1.xml");

        HelloApi helloApi = context.getBean(HelloApi.class);

        helloApi.sayHello();
    }

}