package factory.reflect;

/**
 * Created by wyzhangdongsheng1 on 2014/8/29.
 */
public class NormalFactory {
    public static fruit getInstance(String fruitName){
        fruit f = null;
        if("Apple".equals(fruitName))
            f = new Apple();
        else if("Orange".equals(fruitName))
            f = new Orange();
        return f;
    }

    public static void main(String[] args) {
        fruit f = NormalFactory.getInstance("Apple");
        f.eat();
    }
}
