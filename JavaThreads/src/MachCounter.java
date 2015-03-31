import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.*;

/**
 * Created by wyzhangdongsheng1 on 2014/9/17.
 */
public class MachCounter implements Callable<Integer> {
    private File directory;
    private String keyword;
    private ExecutorService pool;
    private int count;

    public MachCounter(File dir, String keyword, ExecutorService pool) {
        this.directory = dir;
        this.keyword = keyword;
        this.pool = pool;
    }

    @Override
    public Integer call() {
        count = 0;

        File[] files = directory.listFiles();
        ArrayList<Future<Integer>> results = new ArrayList<Future<Integer>>();

        for (File file : files) {
            if (file.isDirectory()) {
                MachCounter counter = new MachCounter(file, keyword, pool);
                Future<Integer> result = pool.submit(counter);
                results.add(result);
            } else {
                if (search(file)) count++;
            }
            for(Future<Integer> result : results){
                try {
                    count += result.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public boolean search(File file) {
        try {
            Scanner in;
            in = new Scanner(new FileInputStream(file));
            boolean found = false;
            while (!found && in.hasNextLine()) {
                String line = in.nextLine();
                if (line.contains(keyword)) found = true;
            }
            in.close();
            return found;
        } catch (FileNotFoundException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        String dir = "";
        String keyword = "";
        ExecutorService pool = Executors.newCachedThreadPool();
        MachCounter counter = new MachCounter(new File(dir), keyword, pool);
        Future<Integer> result = pool.submit(counter);
        try {
            System.out.println(result.get() + "maching files.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
