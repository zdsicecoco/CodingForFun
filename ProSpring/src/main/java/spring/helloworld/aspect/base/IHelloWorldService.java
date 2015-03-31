package spring.helloworld.aspect.base;

/**
 * Created by wyzhangdongsheng1 on 14-12-2.
 */
public interface IHelloWorldService {
    public void sayHello();
    public void sayBefore(String param);
    public boolean sayAfterReturning();
    public void sayAfterThrowing();
    public boolean sayAfterFinally();
    public void sayAround(String param);
    public void sayAdvisorBefore(String param);
}
