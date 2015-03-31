package SharedObjects;

/**
 * Created by wyzhangdongsheng1 on 2014/10/1.
 */
public class NoVisibility {
    public static boolean ready;
    public static int number;

    private static class ReaderThread extends Thread{
        public void run(){
            while(!ready){
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        int num = 10000;
        while(num-- != 0) {
            new ReaderThread().start();
            number = 42;
            ready = true;
        }
    }
}
