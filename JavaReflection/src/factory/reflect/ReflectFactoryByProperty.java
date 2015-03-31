package factory.reflect;

import java.io.*;
import java.util.Properties;

/**
 * Created by wyzhangdongsheng1 on 2014/8/29.
 */
public class ReflectFactoryByProperty {
    public static void main(String[] args) throws IOException {
        Properties pro = init.getPro();
        fruit f = ReflectFactory.getInstance(pro.getProperty("apple"));
        if(f != null)
            f.eat();
    }
}

class init{
    public static Properties getPro() throws IOException {
        Properties pro = new Properties();
        File f = new File("fruit.properties");
        if(f.exists()){
            pro.load(new FileInputStream(f));
        } else{
            pro.setProperty("apple", "factory.reflect.Apple");
            pro.setProperty("orange", "factory.reflect.Orange");
            pro.store(new FileOutputStream(f), "FRUIT CLASS");
        }
        return pro;
    }
}