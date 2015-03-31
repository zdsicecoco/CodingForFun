/**
 * Created by wyzhangdongsheng1 on 2014/8/29.
 */
public class ThreadDemo {
    public static void main(String[] args) {
        new NewThread();
        try{
            for (int i = 5; i > 0; i--) {
                System.out.println("Main Thread:" + i);
                Thread.sleep(100);
            }
        } catch (InterruptedException e){
            System.out.println("Main thread interrupted.");
        }
        System.out.println("Main thread exiting.");
    }
}

class NewThread implements Runnable{
    Thread t;
    public NewThread(){
        //创建第二个线程
        t = new Thread(this, "Demo Thread.");
        System.out.println("Child thread:" + t);
        t.start();
    }

    public void run(){
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Child Thread:" + i);
                Thread.sleep(50 );
            }
        } catch (InterruptedException e){
            System.out.println("Child interrupted.");
        }
        System.out.println("Exiting child thread.");
    }
}