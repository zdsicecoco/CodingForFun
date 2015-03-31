package zds.spring_pattern.adapter_controller;

/**
 * Created by wyzhangdongsheng1 on 15-1-1.
 */
public class HttpHandlerAdapter implements HandlerAdapter {
    @Override
    public boolean supports(Object handler) {
        return (handler instanceof  HttpController);
    }

    @Override
    public void handle(Object handler) {
        ((HttpController)handler).doHttpHandler();
    }
}
