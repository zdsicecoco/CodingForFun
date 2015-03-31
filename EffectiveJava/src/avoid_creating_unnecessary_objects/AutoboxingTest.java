package avoid_creating_unnecessary_objects;

/**
 * Created by wyzhangdongsheng1 on 2014/9/9.
 */
public class AutoboxingTest {
    public static void test1(){
        Long sum = 0L;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println(sum);
    }

    public static void test2(){
        long sum = 0L;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println("Test1:");
        test1();
        System.out.println(System.currentTimeMillis() - start);

        System.out.println("Test2");
        start = System.currentTimeMillis();
        test2();
        System.out.println(System.currentTimeMillis() - start);

    }
}
