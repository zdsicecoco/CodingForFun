package date;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * Created by wyzhangdongsheng1 on 2014/9/1.
 */
public class DateServer {
    public static void main(String[] args) throws IOException {
        ServerSocket listener = new ServerSocket(9090);
        try {
            while(true){
                Socket socket = listener.accept();
                try {
                    PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
                    out.println(new Date().toString());
                    System.out.println(socket.getInetAddress());
                } finally {
                    socket.close();
                }
            }
        } finally {
            listener.close();
        }
    }
}
