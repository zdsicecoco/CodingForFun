package chapter6;

/**
 * Created by wyzhangdongsheng1 on 2014/9/23.
 */
public class Counter {
    private static int count = 0;
    public static synchronized int getCount(){
        return ++count;
    }

}
