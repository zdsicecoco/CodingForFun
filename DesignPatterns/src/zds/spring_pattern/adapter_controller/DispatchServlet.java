package zds.spring_pattern.adapter_controller;

import sun.print.resources.serviceui;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wyzhangdongsheng1 on 15-1-1.
 */
public class DispatchServlet {
    public static List<HandlerAdapter> handlerAdapters = new ArrayList<HandlerAdapter>();

    public DispatchServlet(){
        handlerAdapters.add(new AnotationHandlerAdapter());
        handlerAdapters.add(new HttpHandlerAdapter());
        handlerAdapters.add(new SimpleHandlerAdapter());
    }

    public void doDispatch(){
        SimpleController controller = new SimpleController();

        HandlerAdapter adapter = getHandler(controller);
        adapter.handle(controller);
    }

    public HandlerAdapter getHandler(Controller controller){
        for(HandlerAdapter adapter : this.handlerAdapters){
            if(adapter.supports(controller)){
                return adapter;
            }
        }
        System.err.println("null");
        return null;
    }

    public static void main(String[] args) {
        new DispatchServlet().doDispatch();
    }
}
