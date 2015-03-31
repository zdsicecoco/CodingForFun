package read.write.lock;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by wyzhangdongsheng1 on 15-2-10.
 */
public class ReadWriteLockData {
    private int data;
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void set(int data) {
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "准备写入数据");
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.data = data;
            System.out.println(Thread.currentThread().getName() + "写入" + this.data);
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public void get() {
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "准备读取数据");

            System.out.println(Thread.currentThread().getName() + "读取" + this.data);
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public static void main(String[] args) {
        final SyncData syncData = new SyncData();

        //写入
        for (int i = 0; i < 3; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 5; j++) {
                        syncData.set(new Random().nextInt(30));
                    }
                }
            });
            t.setName("Thread-W" + i);
            t.start();
        }
        //读取
        for (int i = 0; i < 300; i++) {
            Thread t = new Thread(new Runnable() {

                @Override
                public void run() {
                    for (int j = 0; j < 10; j++) {
                        syncData.get();
                    }
                }
            });
            t.setName("Thread-R" + i);
            t.start();
        }
    }

}
