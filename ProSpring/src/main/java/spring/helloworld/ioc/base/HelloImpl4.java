package spring.helloworld.ioc.base;

import spring.helloworld.ioc.base.HelloApi;

/**
 * Created by wyzhangdongsheng1 on 14-11-27.
 */
public class HelloImpl4 implements HelloApi {
    private String message;
    private int index;

    public String getMessage() {
        return message;
    }

    public int getIndex() {
        return index;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public void sayHello() {
        System.out.println(index + ":" + message);
    }
}
