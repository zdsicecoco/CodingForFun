package spring.helloworld;

import com.sun.org.apache.xpath.internal.SourceTree;
import javafx.application.Application;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.helloworld.aspect.base.HelloWorldService;
import spring.helloworld.aspect.base.IHelloWorldService;
import spring.helloworld.aspect.base.IIntroductionService;

import java.nio.charset.Charset;

/**
 * Created by wyzhangdongsheng1 on 14-12-2.
 */
public class AOPTest {
    @Test
    public void testHelloWorld(){
        ApplicationContext context = new ClassPathXmlApplicationContext("aopbase.xml");
        IHelloWorldService helloWorldService = context.getBean("helloWorldService", IHelloWorldService.class);
        helloWorldService.sayHello();
    }

    @Test
    public void testSchemaBeforeAdvice(){
        System.out.println("=============================================");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("advice.xml");
        IHelloWorldService helloWorldService = applicationContext.getBean("helloWorldService", IHelloWorldService.class);
        helloWorldService.sayBefore("before");
        System.out.println("=============================================");
    }

    @Test
    public void testSchemaAfterReturningAdvice(){
        System.out.println("==============================================");
        ApplicationContext context = new ClassPathXmlApplicationContext("advice.xml");
        IHelloWorldService helloWorldService = context.getBean("helloWorldService", IHelloWorldService.class);
        helloWorldService.sayAfterReturning();
        System.out.println("==============================================");
    }

    @Test(expected = RuntimeException.class)
    public void testSchemaAfterThrowingAdvice(){
        System.out.println("==============================================");
        ApplicationContext context = new ClassPathXmlApplicationContext("advice.xml");
        IHelloWorldService helloWorldService = context.getBean("helloWorldService", IHelloWorldService.class);
        helloWorldService.sayAfterThrowing();
        System.out.println("==============================================");
    }

    @Test(expected = RuntimeException.class)
    public void testSchemaAfterFinallyAdvice(){
        System.out.println("==============================================");
        ApplicationContext context = new ClassPathXmlApplicationContext("advice.xml");
        IHelloWorldService helloWorldService = context.getBean("helloWorldService", IHelloWorldService.class);
        helloWorldService.sayAfterFinally();
        System.out.println("==============================================");
    }

    @Test
    public void testSchemaAroundAdvice(){
        System.out.println("==============================================");
        ApplicationContext context = new ClassPathXmlApplicationContext("advice.xml");
        IHelloWorldService helloWorldService = context.getBean("helloWorldService", IHelloWorldService.class);
        helloWorldService.sayAround("haha");
        System.out.println("==============================================");
    }

    @Test
    public void testSchemaIntroduction(){
        System.out.println("===============================================");
        ApplicationContext context = new ClassPathXmlApplicationContext("advice.xml");
        IIntroductionService introductionService = context.getBean("helloWorldService", IIntroductionService.class);
        introductionService.induct();
        System.out.println("===============================================");
    }

    @Test
    public void testSchemaAdvisor(){
        System.out.println("===============================================");
        ApplicationContext context = new ClassPathXmlApplicationContext("advice.xml");
        IHelloWorldService helloWorldService = context.getBean("helloWorldService", IHelloWorldService.class);
        helloWorldService.sayAdvisorBefore("haha");
        System.out.println("===============================================");
    }

    @Test
    public void testAnnotationBeforeAdvice(){
        System.out.println("===============================================");
        ApplicationContext context = new ClassPathXmlApplicationContext("advice2.xml");
        IHelloWorldService helloWorldService = context.getBean("helloWorldService", IHelloWorldService.class);
        helloWorldService.sayAdvisorBefore("before");
        System.out.println("===============================================");
    }
    @Test
    public void testAnnotationAfterAdvice(){
        System.out.println("===============================================");
        ApplicationContext context = new ClassPathXmlApplicationContext("advice2.xml");
        IHelloWorldService helloWorldService = context.getBean("helloWorldService", IHelloWorldService.class);
        helloWorldService.sayAfterReturning();
        System.out.println("===============================================");
    }
}
