/**
 * Created by wyzhangdongsheng1 on 2014/8/29.
 */
public class ThreadShutdownDemo {
    public static void main(String[] args) {
        Runner runner = new Runner();
        Thread thread = new Thread(runner);
        thread.start();
        for (int i = 0; i < 100; i++) {
            if(i % 10 != 0)
                System.out.println("主线程中 i=" + i);
        }
        System.out.println("主线程main结束");
        runner.shutdown();
    }

}

class Runner implements Runnable {
    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while(flag == true){
            System.out.println("子进程：" + i++);
        }
        System.out.println("子进程结束");
    }

    public void shutdown(){
        flag = false;
    }

}