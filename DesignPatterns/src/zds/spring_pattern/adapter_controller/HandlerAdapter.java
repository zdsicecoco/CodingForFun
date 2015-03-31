package zds.spring_pattern.adapter_controller;

/**
 * Created by wyzhangdongsheng1 on 15-1-1.
 */
public interface HandlerAdapter {
    public boolean supports(Object handler);
    public void handle(Object handler);
}
