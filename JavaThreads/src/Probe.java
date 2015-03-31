/**
 * Created by wyzhangdongsheng1 on 2014/8/29.
 */
public class Probe {
    public Probe() {}
    public void run() {
        while(true) {
            Thread[] x = new Thread[100];
            Thread.enumerate(x);
            for(int i=0; i<100; i++) {
                Thread t = x[i];
                if(t == null)
                    break;
                else
                    System.out.println(t.getName() + "\t" + t.getPriority()
                            + "\t" + t.isAlive() + "\t" + t.isDaemon());
            }
        }
    }
}
