package zds;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.List;

/**
 * Created by wyzhangdongsheng1 on 15-1-22.
 */
public class NIOTest {
    public static void testRead(){
        try {
            FileInputStream fileInputStream = new FileInputStream("d:/test.txt");
            FileChannel fileChannel = fileInputStream.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            fileChannel.read(byteBuffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void testWrite(){
        List
        try {
            byte[] message = "zds123456".getBytes();
            FileOutputStream fileOutputStream = new FileOutputStream("d:/test.txt");
            FileChannel fileChannel = fileOutputStream.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            for(int i = 0; i < message.length; i++){
                byteBuffer.put(message[i]);
            }
            byteBuffer.flip();
            fileChannel.write(byteBuffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
