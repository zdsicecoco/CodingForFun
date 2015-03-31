package zds.proxy_pattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by wyzhangdongsheng1 on 15-1-11.
 */
public class BusinessProcessorHandler implements InvocationHandler {
    private Object target = null;

    public BusinessProcessorHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before business");
        Object result = method.invoke(target, args);
        System.out.println("after business.");
        return result;
    }
}
