package spring.helloworld.ioc.base;

/**
 * Created by wyzhangdongsheng1 on 14-11-27.
 */
public class DependencyInjectByStaticFactory {
    public static HelloApi newInstance(String message, int index){
        return new HelloImpl3(message, index);
    }
}
