import java.io.*;

/**
 * Created by wyzhangdongsheng1 on 2014/10/31.
 */
public class ReaderTest {
    public static void main(String[] args) throws IOException {
        streamTest();
    }

    public static void readerTest() throws IOException {
        Reader reader = new FileReader("C:\\Users\\Administrator\\Desktop\\ceshi.txt");
        int data = reader.read();
        while (data != -1) {
            char dataChar = (char) data;
            data = reader.read();
            System.out.print(dataChar);
        }
    }

    public static void streamTest() throws IOException {
        InputStream inputStream = new FileInputStream("C:\\Users\\Administrator\\Desktop\\ceshi.txt");
        int data = inputStream.read();
        while (data != -1) {
            char dataChar = (char) data;
            data = inputStream.read();
            System.out.print(data);
        }
    }
}
