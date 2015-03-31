import java.io.*;
import java.nio.Buffer;
import java.util.Arrays;

/**
 * Created by wyzhangdongsheng1 on 15-1-21.
 */
public class Serialize implements Serializable {
    private static final long serialVersionUID = System.currentTimeMillis();
    public int num = 1390;
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\test.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        Serialize serialize = new Serialize();
        objectOutputStream.writeObject(serialize);
        objectOutputStream.flush();
        objectOutputStream.close();
    }
}
