package spring.helloworld.ioc.base;

import spring.helloworld.ioc.base.HelloApi;

/**
 * Created by wyzhangdongsheng1 on 14-11-27.
 */
public class HelloImpl2 implements HelloApi {
    private String message;

    public HelloImpl2() {
        this.message = "Hello World!";
    }

    public HelloImpl2(String message) {
        this.message = message;
    }

    @Override
    public void sayHello() {
        System.out.println(message);
    }
}
