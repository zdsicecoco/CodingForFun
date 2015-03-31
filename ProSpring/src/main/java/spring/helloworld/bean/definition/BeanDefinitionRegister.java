package spring.helloworld.bean.definition;

import java.util.Map;
import java.util.HashMap;

/**
 * Created by wyzhangdongsheng1 on 14-12-1.
 */
public class BeanDefinitionRegister {
    private final Map<String, BeanDefinition> DEFINITIONS = new HashMap<String, BeanDefinition>();

    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition){
        if(DEFINITIONS.containsKey(beanDefinition.getId())){
            throw new RuntimeException("已存在Bean定义，此实现不允许覆盖");
        }
        DEFINITIONS.put(beanDefinition.getId(), beanDefinition);
    }

    public BeanDefinition getBeanDefinition(String beanName){
        return DEFINITIONS.get(beanName);
    }

    public boolean containsBeanDefinition(String beanName){
        return DEFINITIONS.containsKey(beanName);
    }
}
