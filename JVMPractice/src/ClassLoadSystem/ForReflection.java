package ClassLoadSystem;

import java.util.Map;
import java.util.HashMap;

/**
 * Created by wyzhangdongsheng1 on 15-1-31.
 */
public class ForReflection {
    private Map<String, String> caches = new HashMap<String, String>();
    public void execute(String message){
        String b = this.toString() + message;
        caches.put(b, message);
    }
}
