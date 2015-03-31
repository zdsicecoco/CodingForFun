package zds.spring_pattern.adapter_controller;

/**
 * Created by wyzhangdongsheng1 on 15-1-1.
 */
public class HttpController implements Controller {
    public void doHttpHandler(){
        System.out.println("http...");
    }
}
