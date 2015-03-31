package ClassLoadSystem;

/**
 * Created by wyzhangdongsheng1 on 2014/11/17.
 */
public class NotInitialization {
    public static void main(String[] args) {
//        System.out.println(SubClass.value);
        SuperClass[] sca = new SuperClass[10];
    }
}
