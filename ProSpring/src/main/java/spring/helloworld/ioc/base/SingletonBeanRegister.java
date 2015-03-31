package spring.helloworld.ioc.base;

import org.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.Map;
import java.util.HashMap;

/**
 * Created by wyzhangdongsheng1 on 14-12-1.
 */
public class SingletonBeanRegister implements SingletonBeanRegistry {
    private final Map<String, Object> BEANS = new HashMap<String, Object>();

    @Override
    public void registerSingleton(String beanName, Object singletonObject) {
        if(BEANS.containsKey(beanName)){
            throw new RuntimeException("[" + beanName + "]已存在");
        }
        BEANS.put(beanName, singletonObject);
    }

    @Override
    public Object getSingleton(String beanName) {
        return BEANS.get(beanName);
    }

    @Override
    public boolean containsSingleton(String beanName) {
        return BEANS.containsKey(beanName);
    }

    @Override
    public String[] getSingletonNames() {
        return BEANS.keySet().toArray(new String[0]);
    }

    @Override
    public int getSingletonCount() {
        return BEANS.size();
    }
}
