package ClassLoadSystem;

import java.lang.ref.SoftReference;

/**
 * Created by wyzhangdongsheng1 on 15-2-1.
 */
public class JVMMethodStack {
    public static void main(String[] args) {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                loop(0);
//            }
//            public void loop(int i){
//                if(i != 1000)
//                    i++;
//                else
//                    return;
//            }
//        }).start();
        String object = new String("zds");
        SoftReference<String> softReference = new SoftReference<String>(object);
        object = null;
        System.out.println(softReference.get());
    }
}
