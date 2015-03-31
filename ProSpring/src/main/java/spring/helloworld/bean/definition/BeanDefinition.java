package spring.helloworld.bean.definition;

/**
 * Created by wyzhangdongsheng1 on 14-12-1.
 */
public class BeanDefinition {
    public static final int SCOPE_SINGLETON = 0;
    public static final int SCOPE_PROTOTYPE = 1;

    private String id;
    private String clazz;
    private int scope = SCOPE_SINGLETON;

    public void setId(String id) {
        this.id = id;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public void setScope(int scope) {
        this.scope = scope;
    }

    public static int getScopeSingleton() {

        return SCOPE_SINGLETON;
    }

    public static int getScopePrototype() {
        return SCOPE_PROTOTYPE;
    }

    public String getId() {
        return id;
    }

    public String getClazz() {
        return clazz;
    }

    public int getScope() {
        return scope;
    }


}
