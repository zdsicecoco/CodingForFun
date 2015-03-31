import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by wyzhangdongsheng1 on 2014/9/25.
 */
public class CountingFactorizer {
    private final AtomicLong count = new AtomicLong(0);

    public long getCount(){
        return count.get();
    }

    public void service(ServletRequest req, ServletResponse resp) {
        BigInteger i = extractFromRequest(req);
        BigInteger[] factors = factor(i);
        count.incrementAndGet();
        encodeIntoResponse(resp, factors);
    }

    private BigInteger[] factor(BigInteger i) {
        return new BigInteger[0];
    }

    private BigInteger extractFromRequest(ServletRequest req) {
        return null;
    }

    private void encodeIntoResponse(ServletResponse resp, BigInteger[] factors) {
        
    }


    public static void main(String[] args) {
        System.out.println("zds");
        String[] s = {"你好", "我好", "大家好"};
        System.out.println(s);

    }


}
