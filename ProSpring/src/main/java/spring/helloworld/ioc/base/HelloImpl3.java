package spring.helloworld.ioc.base;

import spring.helloworld.ioc.base.HelloApi;

/**
 * Created by wyzhangdongsheng1 on 14-11-27.
 */
public class HelloImpl3 implements HelloApi {
    private String message;
    private int index;

    @java.beans.ConstructorProperties({"message", "index"})
    public HelloImpl3(String message, int index){
        this.message = message;
        this.index = index;
    }


    @Override
    public void sayHello() {
        System.out.println(index + ":" + message);
    }
}
