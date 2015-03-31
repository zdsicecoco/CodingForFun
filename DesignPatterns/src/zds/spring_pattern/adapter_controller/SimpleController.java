package zds.spring_pattern.adapter_controller;

/**
 * Created by wyzhangdongsheng1 on 15-1-1.
 */
public class SimpleController implements Controller {
    public void doSimpleHandler(){
        System.out.println("simple...");
    }
}
