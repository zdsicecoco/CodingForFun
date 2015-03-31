import java.math.BigDecimal;

/**
 * Created by wyzhangdongsheng1 on 2014/9/5.
 */

//一定要用
//BigDecimal(String)构造器，而千万不要用 BigDecimal(double)。

//在需要精确答案的地方，要避免使用 float 和 double；对于货币计算，
//        要使用 int、long 或 BigDecimal。对于语言设计者来说，应该考虑对小数运算
//        提供语言支持。一种方式是提供对操作符重载的有限支持，以使得运算符可以被
//        塑造为能够对数值引用类型起作用，例如 BigDecimal
public class Find0 {
    public static void main(String[] args) {
//        System.out.println(new BigDecimal("2.00").
//                subtract(new BigDecimal("1.10")));
        System.out.println(12345 + 5432L);
    }
}
