package spring.helloworld.ioc.base;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by wyzhangdongsheng1 on 14-11-28.
 */
public class NavigationB {
    private NavigationC navigationC;
    private List<NavigationC> list;
    private Properties properties;
    private NavigationC[] array = new NavigationC[1];
    private Map<String, NavigationC> map;

    public void setNavigationC(NavigationC navigationC) {
        this.navigationC = navigationC;
    }

    public void setList(List<NavigationC> list) {
        this.list = list;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setArray(NavigationC[] array) {
        this.array = array;
    }

    public void setMap(Map<String, NavigationC> map) {
        this.map = map;
    }

    public NavigationC getNavigationC() {

        return navigationC;
    }

    public List<NavigationC> getList() {
        return list;
    }

    public Properties getProperties() {
        return properties;
    }

    public NavigationC[] getArray() {
        return array;
    }

    public Map<String, NavigationC> getMap() {
        return map;
    }
}
