package zds.spring_pattern.adapter_controller;

/**
 * Created by wyzhangdongsheng1 on 15-1-1.
 */
public class SimpleHandlerAdapter implements HandlerAdapter {
    @Override
    public boolean supports(Object handler) {
        return (handler instanceof SimpleController);
    }

    @Override
    public void handle(Object handler) {
        ((SimpleController)handler).doSimpleHandler();
    }
}
