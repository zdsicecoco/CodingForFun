package spring.helloworld.ioc.base;

import spring.helloworld.ioc.base.HelloApi;

/**
 * Created by wyzhangdongsheng1 on 14-11-28.
 */
public class HelloApiDecorator implements HelloApi {
    private HelloApi helloApi;

    public HelloApiDecorator() {
    }

    public HelloApiDecorator(HelloApi helloApi) {
        this.helloApi = helloApi;
    }

    public void setHelloApi(HelloApi helloApi){
        this.helloApi = helloApi;
    }

    @Override
    public void sayHello() {
        System.out.println("=====================装饰一下======================");
        helloApi.sayHello();
        System.out.println("=====================装饰一下======================");
    }
}
