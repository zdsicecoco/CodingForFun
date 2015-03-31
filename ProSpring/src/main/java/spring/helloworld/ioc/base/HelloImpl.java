package spring.helloworld.ioc.base;

import spring.helloworld.ioc.base.HelloApi;

/**
 * Created by wyzhangdongsheng1 on 2014/11/20.
 */
public class HelloImpl implements HelloApi {
    @Override
    public void sayHello() {
        System.out.println("Hello World!");
    }
}
