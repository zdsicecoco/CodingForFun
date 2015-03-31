import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by wyzhangdongsheng1 on 2014/9/3.
 */
public class ServiceProviderFrameworkSketch {
    public static void main(String[] args) {
    }

}

class TestSubClass{
    private  TestSubClass(){}
}


//service interface
interface Service{}
//service provider interface
interface Provider{
    Service newService();
}
//noninstantialble class for service registration and access
class Services{
    private Services(){}

    //Maps service names to services
    private static final Map<String, Provider> providers = new ConcurrentHashMap<String, Provider>();
    public static final String DEFAULT_PROVIDER_NAME  = "<def>";
    //Provider registration API
    public static void registerDefaultProvider(Provider p){
        registerProvider(DEFAULT_PROVIDER_NAME, p);
    }
    public static void registerProvider(String name, Provider p){
        providers.put(name, p);
    }
    //Service access API
    public static Service newInstance(){
        return newInstance(DEFAULT_PROVIDER_NAME);
    }
    public static Service newInstance(String name){
        Provider p = providers.get(name);
        if(p == null)
            throw new IllegalArgumentException("No provider registered with name:" + name);
        return p.newService();
    }

}