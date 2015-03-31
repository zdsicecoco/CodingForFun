package SearchStringInABaseDir;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

/**
 * Created by wyzhangdongsheng1 on 2014/9/4.
 */
public class SearchTask implements Runnable {
    private BlockingQueue<File> queue;
    private String keyword;

    public SearchTask(BlockingQueue<File> queue, String keyword) {
        this.queue = queue;
        this.keyword = keyword;
    }

    public void search(File file) {
        Scanner in = null;
        try {
            in = new Scanner(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int lineNumber = 0;
        while (in.hasNextLine()) {
            lineNumber++;
            String line = in.nextLine();
            if (line.contains(keyword)) System.out.printf("%s:%d:%s:%n", file.getPath(), lineNumber, line);
        }
        in.close();
    }

    @Override
    public void run() {
        boolean done = false;
        try {
            while (!done) {
                File file = queue.take();
                if (file == FileEnumerationTask.DUMMY) {
                    queue.put(file);
                    done = true;
                } else search(file);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
