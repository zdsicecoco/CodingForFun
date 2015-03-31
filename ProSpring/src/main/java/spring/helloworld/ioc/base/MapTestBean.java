package spring.helloworld.ioc.base;

import java.util.Map;

/**
 * Created by wyzhangdongsheng1 on 14-11-28.
 */
public class MapTestBean {
    private Map<String, String> map;

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}
