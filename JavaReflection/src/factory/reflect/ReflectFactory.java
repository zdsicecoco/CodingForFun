package factory.reflect;

import java.sql.Ref;

/**
 * Created by wyzhangdongsheng1 on 2014/8/29.
 */
public class ReflectFactory {
    public static fruit getInstance(String ClassName) {
        fruit f = null;
        try {
            f = (fruit) Class.forName(ClassName).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

    public static void main(String[] args) {
        fruit f = ReflectFactory.getInstance("factory.reflect.Orange");
        if (f != null)
            f.eat();
    }
}
