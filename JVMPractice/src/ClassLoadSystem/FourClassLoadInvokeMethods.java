package ClassLoadSystem;

/**
 * Created by wyzhangdongsheng1 on 15-1-31.
 */
public class FourClassLoadInvokeMethods {
    public void execute(){
        A.execute();
        A a = new A();
        a.bar();
        IFoo b = new B();
        b.bar();
    }
}

class A{
    public static int execute(){
        return 2 + 1;
    }
    public int bar(){
        return 1 + 2;
    }
}

class B implements IFoo{
    @Override
    public int bar() {
        return 1 + 2;
    }

}

interface IFoo{
    int bar();
}
