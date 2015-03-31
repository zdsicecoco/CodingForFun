package spring.helloworld.ioc.base;

/**
 * Created by wyzhangdongsheng1 on 14-11-27.
 */
public class HelloApiInstanceFactory {
    public HelloApi newInstance(String message){
        return new HelloImpl2(message);
    }
}
