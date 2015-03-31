package zds.generictype;

import java.math.BigDecimal;

/**
 * Created by wyzhangdongsheng1 on 2014/9/15.
 */
public class BoundedTypeTest {
    public static void main(String[] args) {
        Box<Integer> integerBoxbox = new Box<Integer>();
        integerBoxbox.setT(new Integer(10));
        integerBoxbox.inspect(new BigDecimal(20));
    }
}

class Box<T>{
    private T t;

    public void setT(T t) {
        this.t = t;
    }

    public T getT() {

        return t;
    }

    public <U extends Number> void inspect(U u){
        System.out.println("T t:" + t.getClass().getName());
        System.out.println("U u:" + u.getClass().getName());
    }
}
