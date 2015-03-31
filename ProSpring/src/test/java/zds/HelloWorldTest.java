package zds;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by wyzhangdongsheng1 on 15-1-14.
 */
public class HelloWorldTest {
    @Test
    public void test(){

        ApplicationContext context = new ClassPathXmlApplicationContext("hello.xml");
        IHello hello1 = context.getBean("hello", IHello.class);
//        IHello hello2 = context.getBean("hello1", IHello.class);
//        IHello hello3 = context.getBean("idref", IHello.class);
//        hello1.sayHello();
//        hello2.sayHello();
//        hello3.sayHello();
    }
}
