package SearchStringInABaseDir;

import java.io.File;
import java.util.concurrent.BlockingQueue;

/**
 * Created by wyzhangdongsheng1 on 2014/9/4.
 */
public class FileEnumerationTask implements Runnable {
    private BlockingQueue<File> blockingQueue;
    private String baseDir;
    public static File DUMMY = new File("");
    public FileEnumerationTask(BlockingQueue<File> blockingQueue, String baseDir) {
        this.baseDir = baseDir;
        this.blockingQueue = blockingQueue;
    }

    public void enumerate(File file) {

        for (File f : file.listFiles()) {
            if (f.isDirectory()) {
                enumerate(f);
            } else
                try {
                    blockingQueue.put(f);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }

    @Override
    public void run() {
        enumerate(new File(baseDir));
        try {
            blockingQueue.put(DUMMY);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
