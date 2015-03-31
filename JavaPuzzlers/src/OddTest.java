/**
 * Created by wyzhangdongsheng1 on 2014/9/5.
 */
public class OddTest {
    public static boolean isOdd(int i){
//        System.out.println(i & 1);
        return (i & 1) != 0;
    }

    public static void main(String[] args) {
        System.out.println(isOdd(-1));;
    }
}
