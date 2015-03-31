/**
 * Created by wyzhangdongsheng1 on 2014/8/29.
 */
public class ThreadJoinDemo {
    public static void main(String[] args) {
        Runner2 r = new Runner2();
        Thread t = new Thread(r);
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 5; i++) {
            System.out.println("主线程：" + i);
        }
    }
}

class Runner2 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("子线程：" + i);
        }
    }
}