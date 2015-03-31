package spring.helloworld.ioc.base;

/**
 * Created by wyzhangdongsheng1 on 14-11-27.
 */
public class HelloApiStaticFactory {
    public static HelloApi newInstance(String message){
        return new HelloImpl2(message);
    }
}
