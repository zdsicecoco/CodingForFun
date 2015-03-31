import reflect.Person;

/**
 * Created by wyzhangdongsheng1 on 2014/8/29.
 */
public class ClassLoader {
    public static void main(String[] args) {
        Person per = new Person();
        System.out.println("类加载器：" + per.getClass().getClassLoader().getClass().getName());
    }
}
