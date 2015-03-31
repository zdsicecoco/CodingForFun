package date;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by wyzhangdongsheng1 on 2014/9/1.
 */
public class DateClient {
    public static void main(String[] args) throws IOException {
        byte[] address = InetAddress.getLocalHost().getAddress();
        System.out.print(address);
        String serverAddress = JOptionPane.showInputDialog("Enter IP Address of a machine that is\n" +
                "running the date service on port 9090:");
        Socket s = new Socket(serverAddress, 9090);
        BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String answer = input.readLine();
        JOptionPane.showMessageDialog(null, answer);
        System.exit(0);
    }

}
