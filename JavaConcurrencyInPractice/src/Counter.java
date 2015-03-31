import java.util.HashSet;
import java.util.TimerTask;

/**
 * Created by wyzhangdongsheng1 on 2014/10/22.
 */
public final class Counter {
    private long value = 0;

    public synchronized long getValue(){
        return value;
    }

    public synchronized long increment(){
        if (value == Long.MAX_VALUE) {
            throw new IllegalArgumentException("counter overflow");
        }
        return ++ value;
    }

    public static void main(String[] args) {

    }

}
