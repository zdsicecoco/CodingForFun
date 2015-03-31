import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by wyzhangdongsheng1 on 2014/8/28.
 */
public class ManipulationTests {

    public void test1() {
        Class<?> demo = null;
        try {
            demo = Class.forName("reflect.ChinaMan");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Method method = demo.getMethod("sayChina");
            method.invoke(demo.newInstance());

            method = demo.getMethod("sayHello", String.class, int.class);
            method.invoke(demo.newInstance(), "zds", 10);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void test2() {
        Class<?> demo = null;
        try {
            demo = Class.forName("reflect.ChinaMan");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //调用其他类的set和get方法
        System.out.println("调用其他类的set和get方法");
        Object obj = null;
        try {
            obj = demo.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        setter(obj, "Sex", "男", String.class);
        getter(obj, "Sex");

    }

    //通过反射操作属性
    public static void test3(Class<?> demo, Object obj) {
        Field field = null;
        try {
            field = demo.getDeclaredField("sex");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        field.setAccessible(true);
        try {
            field.set(obj, "男");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(field.get(obj));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    //通过反射取得并修改数组的信息
    public static void test4() {
        int[] temp = {1,2,3,4,5};
        Class<?> demo = temp.getClass().getComponentType();
        System.out.println("数组类型：" + demo.getName());
        System.out.println("数组长度：" + Array.getLength(temp));
        System.out.println("数组的第一个元素：" + Array.get(temp, 0));
        Array.set(temp, 0, 100);
        System.out.println("修改后数组的第一个元素：" + Array.get(temp, 0));
    }

    public static void main(String[] args) {
        Class<?> demo = null;
        try {
            demo = Class.forName("reflect.ChinaMan");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Object obj = null;
        try {
            obj = demo.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

//        test3(demo, obj);
        test4();
    }

    public static void getter(Object obj, String att) {
        try {
            Method method = obj.getClass().getMethod("get" + att);
            System.out.println(method.invoke(obj));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setter(Object obj, String att, Object value, Class<?> type) {
        try {
            Method method = obj.getClass().getMethod("set" + att, type);
            method.invoke(obj, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
