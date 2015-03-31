package GeneralContractEquals;

/**
 * Created by wyzhangdongsheng1 on 2014/9/11.
 */
public class InstanceOfTest {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();
        System.out.println(b instanceof A);
    }
}

class A{}
class B extends A{}
class C extends A{}
