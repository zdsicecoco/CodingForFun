package reentrant.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wyzhangdongsheng1 on 15-2-10.
 */
public class Outputter1 {
    private Lock lock = new ReentrantLock();

    public void output(String name){
        lock.lock();
        try{
            for(int i = 0; i < name.length(); i++){
                System.out.print(name.charAt(i));
            }
        } finally {
            lock.unlock();
        }
    }
}
