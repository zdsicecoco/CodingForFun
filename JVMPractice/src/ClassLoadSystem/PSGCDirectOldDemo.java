package ClassLoadSystem;

/**
 * Created by wyzhangdongsheng1 on 15-2-2.
 */
public class PSGCDirectOldDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(15000);
        byte[] bytes = new byte[1024 * 1024 * 2];
        byte[] bytes2 = new byte[1024 * 1024 * 2];
        byte[] bytes3 = new byte[1024 * 1024 * 2];
        System.out.println("ready to direct allocate to old");
        Thread.sleep(5000);
        byte[] bytes4 = new byte[1024 * 1024 * 4];
        Thread.sleep(5000);
    }
}
