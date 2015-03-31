import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by wyzhangdongsheng1 on 2014/9/1.
 */
public class BlockingQueueTest {
    public static void main(String[] args) {
        String baseDirectory = "E:\\";
        String keyword = "logging";
        Scanner in = new Scanner(baseDirectory);
        System.out.println("Base directory:" + baseDirectory);
        System.out.println("Keyword:" + keyword);

        final int FIlE_QUEUE_SIZE = 10;
        final int SEARCH_THREADS = 2;

        BlockingQueue<File> queue = new ArrayBlockingQueue<File>(FIlE_QUEUE_SIZE);

        FileEnumerationTask enumerator = new FileEnumerationTask(queue, new File(baseDirectory));
        new Thread(enumerator).start();
        for (int i = 0; i < SEARCH_THREADS; i++) {
            new Thread(new SearchTask(queue, keyword)).start();
        }
    }
}

class FileEnumerationTask implements Runnable {
    public static File DUMMY = new File("");

    private BlockingQueue<File> queue;
    private File startingDirectory;

    public FileEnumerationTask(BlockingQueue<File> queue, File staringDirectory) {
        this.queue = queue;
        this.startingDirectory = staringDirectory;
    }


    @Override
    public void run() {
        try {
            enumerate(startingDirectory);
            queue.put(DUMMY);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void enumerate(File directory) throws InterruptedException {
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                enumerate(file);
            } else
                queue.put(file);
        }
    }
}


class SearchTask implements Runnable {
    private BlockingQueue<File> queue;
    private String keyword;

    public SearchTask(BlockingQueue<File> queue, String keyword) {
        this.queue = queue;
        this.keyword = keyword;
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
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
        }
    }

    public void search(File file) throws FileNotFoundException {
        Scanner in = new Scanner(new FileInputStream(file));
        int lineNumber = 0;
        while (in.hasNextLine()) {
            lineNumber++;
            String line = in.nextLine();
            if (line.contains(keyword))
                System.out.printf("%s:%d:%s:%n", file.getPath(), lineNumber, line);
        }
        in.close();
    }
}