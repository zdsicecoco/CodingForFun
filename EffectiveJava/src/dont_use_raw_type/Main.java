package dont_use_raw_type;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wyzhangdongsheng1 on 15-1-28.
 */
public class Main {
    public static void unsafeAdd(List<Object> list, Object object){
        list.add(object);
    }
    public static void main(String[] args) {
        List<String> strings = new ArrayList<String>();
//        unsafeAdd(strings, new Integer(42));
    }
}
