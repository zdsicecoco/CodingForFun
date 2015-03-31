package spring.helloworld;

import junit.framework.Assert;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.helloworld.bean.definition.BeanDefinition;
import spring.helloworld.bean.definition.DefaultBeanFactory;
import spring.helloworld.ioc.base.*;

import java.io.IOException;

/**
 * Created by wyzhangdongsheng1 on 14-11-27.
 */
public class MainTest {
    @org.junit.Test
    public void testInstantiatingBeanByConstructor() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("instantiatingBean.xml");
        HelloApi bean1 = beanFactory.getBean("bean1", HelloApi.class);
        bean1.sayHello();
        HelloApi bean2 = beanFactory.getBean("bean2", HelloApi.class);
        bean2.sayHello();
    }

    @org.junit.Test
    public void testInstantiatingBeanByStaticFactory() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("instantiatingBean.xml");
        HelloApi bean3 = beanFactory.getBean("bean3", HelloApi.class);
        bean3.sayHello();
    }

    @org.junit.Test
    public void testInstantiatingBeanByInstanceFactory() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("instantiatingBean.xml");
        HelloApi bean4 = beanFactory.getBean("bean4", HelloApi.class);
        bean4.sayHello();
    }

    @org.junit.Test
    public void testConstructorDependencyInjectTest() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("constructorDependencyInject.xml");

        HelloApi byIndex = beanFactory.getBean("byIndex", HelloApi.class);
        byIndex.sayHello();

        HelloApi byType = beanFactory.getBean("byType", HelloApi.class);
        byType.sayHello();

        HelloApi byName = beanFactory.getBean("byPro", HelloApi.class);
        byName.sayHello();
    }

    @org.junit.Test
    public void testDenpendencyInjectByStaticFactory() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("DependencyInject.xml");
        HelloApi bean1 = beanFactory.getBean("byIndex", HelloApi.class);
        bean1.sayHello();
    }

    @org.junit.Test
    public void testDependencyInjectByInstanceFactory() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("DependencyInject.xml");
        HelloApi helloApi = beanFactory.getBean("byInstance", HelloApi.class);
        helloApi.sayHello();
    }

    @org.junit.Test
    public void testSetterDependencyInject() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("setterDependencyInject.xml");
        HelloApi helloApi = beanFactory.getBean("bean", HelloApi.class);
        helloApi.sayHello();
    }

    @org.junit.Test
    public void testListInject() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("listInject.xml");
        ListTestBean listTestBean = beanFactory.getBean("listBean", ListTestBean.class);
        System.out.println(listTestBean.getValues().size());
    }

    @org.junit.Test
    public void testMapInject() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("listInject.xml");
        MapTestBean mapTestBean = beanFactory.getBean("mapBean", MapTestBean.class);
        System.out.println(mapTestBean.getMap());
    }

    @org.junit.Test
    public void testBeanInject() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("beanInject.xml");

        HelloApi bean1 = beanFactory.getBean("bean1", HelloApi.class);
        bean1.sayHello();

        HelloApi bean2 = beanFactory.getBean("bean2", HelloApi.class);
        bean2.sayHello();
    }

    @org.junit.Test
    public void testLocalAndParentBeanInject() {
        ApplicationContext parentBeanContext = new ClassPathXmlApplicationContext("parentBeanInject.xml");
        ApplicationContext beanContext = new ClassPathXmlApplicationContext(new String[]{"localBeanInject.xml"}, parentBeanContext);
        HelloApi bean1 = beanContext.getBean("bean1", HelloApi.class);
        bean1.sayHello();
        HelloApi bean2 = beanContext.getBean("bean2", HelloApi.class);
        bean2.sayHello();
    }

    @org.junit.Test
    public void testNavigationBeanInject() {
        ApplicationContext context = new ClassPathXmlApplicationContext("navigationBeanInject.xml");
        NavigationA navigationA = context.getBean("a", NavigationA.class);
        navigationA.getNavigationB().getNavigationC().sayNavigation();
        navigationA.getNavigationB().getList().get(0).sayNavigation();
        navigationA.getNavigationB().getMap().get("key").sayNavigation();
        navigationA.getNavigationB().getArray()[0].sayNavigation();
        ((NavigationC) navigationA.getNavigationB().getProperties().get("1")).sayNavigation();
    }

    @org.junit.Test(expected = BeanCreationException.class)
    public void testCircleByConstructor() throws Throwable {
        try {
            new ClassPathXmlApplicationContext("circleInjectByConstructor.xml");
        } catch (BeansException e) {
            Throwable e1 = e.getCause().getCause().getCause();
            throw e1;
        }
    }

    @org.junit.Test
    public void testDependentOn() throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dependent.xml");
        context.registerShutdownHook();
        DependentBean dependentBean = context.getBean("dependentBean", DependentBean.class);
        dependentBean.write("aaa");
    }

    @org.junit.Test
    public void testAutowireByName() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("autowire.xml");
        HelloApi helloApi = context.getBean("bean", HelloApi.class);
        helloApi.sayHello();
    }

    @Test
    public void testPrototype(){
        DefaultBeanFactory defaultBeanFactory = new DefaultBeanFactory();

        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setId("bean");
        beanDefinition.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        beanDefinition.setClazz(HelloImpl2.class.getName());
        defaultBeanFactory.registerBeanDefinition(beanDefinition);
        System.out.println(defaultBeanFactory.getBean("bean") != defaultBeanFactory.getBean("bean"));
    }

    @Test
    public void testSingleThread(){
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("scopebean.xml");
        HelloApi bean1 = beanFactory.getBean("helloApi", HelloApi.class);
        HelloApi bean2 = beanFactory.getBean("helloApi", HelloApi.class);
        Assert.assertEquals(bean1, bean2);
    }

    @Test
    public void testTwoThread() throws InterruptedException {
        final BeanFactory beanFactory = new ClassPathXmlApplicationContext("scopebean.xml");
        final HelloApi[] beans = new HelloApi[2];
        Thread thread1 = new Thread(){
            public void run(){
                beans[0] = beanFactory.getBean("helloApi", HelloApi.class);
            }
        };
        Thread thread2 = new Thread(){
            public void run(){
                beans[1] = beanFactory.getBean("helloApi", HelloApi.class);
            }
        };
        thread1.start();
        thread1.sleep(1000);

        thread2.start();
        thread2.sleep(1000);

        Assert.assertEquals(beans[0], (beans[1]));
    }
}
