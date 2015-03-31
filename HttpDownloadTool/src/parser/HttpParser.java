package parser;

import sun.misc.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Created by wyzhangdongsheng1 on 2014/10/28.
 */
public class HttpParser {
    public static Hashtable<String, String> parseFileAndDir(URL url){
        Hashtable<String, String> hashtable = new Hashtable<String, String>();
        try {
            URLConnection urlConnection = url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            StringBuilder stringBuilder = new StringBuilder();
            String inputLine;
            String regSta = "<a href=\"";
            String regMid = "\">";
            String regEnd = "</a>";
            while((inputLine = bufferedReader.readLine()) != null){
                int index1 = inputLine.indexOf(regSta);
                if(index1 != -1){
                    int index2 = inputLine.indexOf(regMid);
                    int index3 = inputLine.indexOf(regEnd);

                    String filePath = inputLine.substring(index1 + 9, index2);
                    String filename = inputLine.substring(index2 + 2, index3);

                    hashtable.put(filename, filePath);

                    System.out.println("filename:" + filename + "\tfilePath:" + filePath);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  hashtable;
    }

    public static void main(String[] args) throws MalformedURLException {
        HttpParser.parseFileAndDir(new URL("http://10.45.241.159:8081/nexus/content/repositories/releases/com/"));
    }
}
