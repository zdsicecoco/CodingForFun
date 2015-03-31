package ibm;// $Id$

import java.io.*;
import java.nio.*;
import java.nio.channels.*;

public class UseFileLocks{

  static public void main( String args[] ){
        for(int i = 0; i < 20; i++){
            System.out.println(i + "...");
            Runnable runnable = new Runtime();
            new Thread(runnable).start();
            try { Thread.sleep( 3500 ); } catch( InterruptedException ie ) {}
        }
  }
}

class Runtime implements Runnable{
    static private final int start = 10;
    static private final int end = 20;
    @Override
    public void run() {
        // Get file channel
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile( "d:/test.txt", "rw" );
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        FileChannel fc = raf.getChannel();

        // Get lock
        System.out.println( "trying to get lock" );
        FileLock lock = null;
        try {
            lock = fc.lock( start, end, false );
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println( "got lock!" );

        // Pause
        System.out.println( "pausing" );
        try { Thread.sleep( 3000 ); } catch( InterruptedException ie ) {}

        // Release lock
        System.out.println( "going to release lock" );
        try {
            lock.release();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println( "released lock" );

        try {
            raf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
