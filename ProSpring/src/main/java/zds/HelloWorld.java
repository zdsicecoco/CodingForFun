package zds;

/**
 * Created by wyzhangdongsheng1 on 15-1-14.
 */
public class HelloWorld implements IHello{
    private String name;

    public HelloWorld() {
    }

    public HelloWorld(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void sayHello() {
        System.out.println("hello:" + name);
    }
}
