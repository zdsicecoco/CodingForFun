import reflect.Demo;
import reflect.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by wyzhangdongsheng1 on 2014/8/28.
 */
public class DisplayTests {
    public static void main(String[] args) {
/*
        //得到 package 和 class name
        Demo demo = new Demo();
        System.out.println(demo.getClass().getName());
*/
/*

        //实例化class对象
        Class<?> demo1 = null;
        Class<?> demo2 = null;
        Class<?> demo3 = null;
        try{
            demo1 = Class.forName("reflect.Demo");
        } catch (Exception e){
            e.printStackTrace();
        }
        demo2 = new Demo().getClass();
        demo3 = Demo.class;

        System.out.println("类名称：" + demo1.getName());
        System.out.println("类名称：" + demo2.getName());
        System.out.println("类名称：" + demo3.getName());
*/
/*

        //通过Class实例化其他类的对象
        Class<?> demo = null;
        try {
            demo = Class.forName("reflect.Person");
        } catch (Exception e){
            e.printStackTrace();
        }
        Person per = null;
        try {
            per = (Person)demo.newInstance();
        } catch (Exception e){
            e.printStackTrace();
        }
        per.setName("zds");
        per.setAge(23);
        System.out.println(per);
*/

        /*//通过Class调用其他类中的构造函数
        Class<?> demo = null;
        try{
            demo = Class.forName("reflect.Person");
        } catch (Exception e){
            e.printStackTrace();
        }
        Person person1 = null;
        Person person2 = null;
        Person person3 = null;
        Person person4 = null;
        //取得全部的构造函数
        Constructor<?>[] cons = demo.getConstructors();
        try{
            person1 = (Person)cons[0].newInstance(10,"zds");
            person2 = (Person)cons[1].newInstance("zds");
            person3 = (Person)cons[2].newInstance(10);
            person4 = (Person)cons[3].newInstance();
        } catch (Exception e){
            e.printStackTrace();;
        }
        System.out.println(person1);
        System.out.println(person2);
        System.out.println(person3);
        System.out.println(person4);
    */
/*
        //返回一个类实现的借口
        Class<?> demo = null;
        try {
            demo = Class.forName("reflect.ChinaMan");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //得到所有的借口
        Class<?> intes[] = demo.getInterfaces();
        for (int i = 0; i < intes.length; i++) {
            System.out.println("实现的接口：" + intes[i].getName());
        }
    */

    /*
        Class<?> demo = null;
        try{
            demo = Class.forName("reflect.ChinaMan");
        } catch (Exception e){
            e.printStackTrace();
        }
        //取得父类
        Class<?> temp = demo.getSuperclass();
        System.out.println(temp.getName());
        //取得所有构造方法
        Constructor<?>[] cons = demo.getConstructors();
        for (int i = 0; i < cons.length; i++) {
            Class<?>[] p = cons[i].getParameterTypes();
            System.out.println("构造方法：\t");
            int mods = cons[i].getModifiers();
            System.out.print(Modifier.toString(mods) + " ");
            System.out.print(cons[i].getName());
            System.out.print("(");
            for (int j = 0; j < p.length; j++){
                System.out.print(p[j].getName() + " arg" + j);
                if(j < p.length - 1){
                    System.out.print(",");
                }
            }
            System.out.println("){}");
        }
    */
        Class<?> demo = null;
        try {
            demo = Class.forName("reflect.ChinaMan");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //取得父类
        System.out.println("===============父类========================");
        Class<?> temp = demo.getSuperclass();
        System.out.println(temp.getName());
        //取得所有构造方法
        System.out.println("===============构造函数========================");
        Constructor<?>[] cons = demo.getConstructors();
        for (int i = 0; i < cons.length; i++) {
            Class<?>[] p = cons[i].getParameterTypes();
            int mods = cons[i].getModifiers();
            System.out.print(Modifier.toString(mods) + " ");
            System.out.print(cons[i].getName());
            System.out.print("(");
            for (int j = 0; j < p.length; j++){
                System.out.print(p[j].getName() + " arg" + j);
                if(j < p.length - 1){
                    System.out.print(",");
                }
            }
            System.out.println("){}");
        }
        System.out.println("===============本地方法========================");
        Method method[] = demo.getMethods();
        for (int i = 0; i < method.length; ++i) {
            Class<?> returnType = method[i].getReturnType();
            Class<?> para[] = method[i].getParameterTypes();
            int tmp = method[i].getModifiers();
            System.out.print(Modifier.toString(tmp) + " ");
            System.out.print(returnType.getName() + "  ");
            System.out.print(method[i].getName() + " ");
            System.out.print("(");
            for (int j = 0; j < para.length; ++j) {
                System.out.print(para[j].getName() + " " + "arg" + j);
                if (j < para.length - 1) {
                    System.out.print(",");
                }
            }
            Class<?> exce[] = method[i].getExceptionTypes();
            if (exce.length > 0) {
                System.out.print(") throws ");
                for (int k = 0; k < exce.length; ++k) {
                    System.out.print(exce[k].getName() + " ");
                    if (k < exce.length - 1) {
                        System.out.print(",");
                    }
                }
            } else {
                System.out.print(")");
            }
            System.out.println();
        }

        System.out.println("===============本类属性========================");
        // 取得本类的全部属性
        Field[] field = demo.getDeclaredFields();
        for (int i = 0; i < field.length; i++) {
            // 权限修饰符
            int mo = field[i].getModifiers();
            String priv = Modifier.toString(mo);
            // 属性类型
            Class<?> type = field[i].getType();
            System.out.println(priv + " " + type.getName() + " "
                    + field[i].getName() + ";");
        }
        System.out.println("===============实现的接口或者父类的属性========================");
        // 取得实现的接口或者父类的属性
        Field[] filed1 = demo.getFields();
        for (int j = 0; j < filed1.length; j++) {
            // 权限修饰符
            int mo = filed1[j].getModifiers();
            String priv = Modifier.toString(mo);
            // 属性类型
            Class<?> type = filed1[j].getType();
            System.out.println(priv + " " + type.getName() + " "
                    + filed1[j].getName() + ";");
        }
    }
}