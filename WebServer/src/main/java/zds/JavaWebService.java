package zds;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by wyzhangdongsheng1 on 15-1-27.
 */
public class JavaWebService {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(9999);
        System.out.println("等待连接。。。");
        Socket socket = server.accept();
        InputStream inputStream = socket.getInputStream();
        System.out.println("input stream...");
        Scanner scannerin = new Scanner(inputStream);
        while(scannerin.hasNext()){
            System.out.println(scannerin.nextLine());
        }
        OutputStream outputStream = socket.getOutputStream();
        System.out.println("连接成功。。。");
        Scanner scanner = new Scanner(new FileReader("D:\\hello.html"));
        String buf="";
        while(scanner.hasNext()){
            outputStream.write(scanner.nextLine().getBytes());
        }
        scanner.close();
        outputStream.close();
        socket.close();
    }
}
