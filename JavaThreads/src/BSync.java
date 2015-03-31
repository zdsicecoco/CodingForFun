/**
 * Created by wyzhangdongsheng1 on 2014/8/29.
 */
public class BSync {
    int totalThreads;
    int currentThreads;

    public BSync(int x) {
        this.totalThreads = x;
        currentThreads = 0;
    }

    public synchronized void waitForAll() {
        currentThreads++;
        if (currentThreads < totalThreads) {
            try {
                wait();
            } catch (Exception e) {}
        } else {
            currentThreads = 0;
            notifyAll();
        }
    }
}
