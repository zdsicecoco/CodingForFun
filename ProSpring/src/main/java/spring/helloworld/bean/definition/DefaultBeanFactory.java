package spring.helloworld.bean.definition;

import spring.helloworld.ioc.base.SingletonBeanRegister;

/**
 * Created by wyzhangdongsheng1 on 14-12-1.
 */
public class DefaultBeanFactory {
    private BeanDefinitionRegister DEFINITIONS = new BeanDefinitionRegister();

    private final SingletonBeanRegister SINGLETONS = new SingletonBeanRegister();

    public Object getBean(String beanName) {

        if (!DEFINITIONS.containsBeanDefinition(beanName)) {
            throw new RuntimeException("不存在[" + beanName + "]Bean定义");
        }

        BeanDefinition beanDefinition = DEFINITIONS.getBeanDefinition(beanName);

        if (beanDefinition.getScope() == BeanDefinition.SCOPE_SINGLETON) {
            if (SINGLETONS.containsSingleton(beanName)) {
                return SINGLETONS.getSingleton(beanName);
            }
            SINGLETONS.registerSingleton(beanName, createBean(beanDefinition));
            return SINGLETONS.getSingleton(beanName);
        }

        if (beanDefinition.getScope() == BeanDefinition.SCOPE_PROTOTYPE) {
            return createBean(beanDefinition);
        }

        throw new RuntimeException("错误的Bean定义");
    }

    public void registerBeanDefinition(BeanDefinition beanDefinition) {
        DEFINITIONS.registerBeanDefinition(beanDefinition.getId(), beanDefinition);
    }

    private Object createBean(BeanDefinition beanDefinition) {
        try {
            Class clazz = Class.forName(beanDefinition.getClazz());
            return clazz.getConstructor().newInstance();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("没有找到Bean[" + beanDefinition.getId() + "]类");
        } catch (Exception e) {
            throw new RuntimeException("创建Bean[" + beanDefinition.getId() + "]失败");
        }
    }
}
