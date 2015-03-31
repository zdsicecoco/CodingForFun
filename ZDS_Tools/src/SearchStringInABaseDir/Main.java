package SearchStringInABaseDir;

import java.io.File;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by wyzhangdongsheng1 on 2014/9/4.
 */
public class Main {
    public static void main(String[] args) {
        String startingDir = "D:\\Program Files (x86)";
        String keyword = "Maven";
        BlockingQueue<File> queue = new LinkedBlockingDeque<File>();
        FileEnumerationTask fet = new FileEnumerationTask(queue, startingDir);
        new Thread(fet).start();
        for(int i = 0; i < 20; i++)
            new Thread(new SearchTask(queue, keyword)).start();
    }
}
