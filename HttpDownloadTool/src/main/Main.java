package main;

import constants.DownloadConstants;
import logger.ZDSLogger;
import parser.HttpParser;
import task.DownloadTask;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by wyzhangdongsheng1 on 2014/10/28.
 */
public class Main {
    public void start() throws MalformedURLException {
        LinkedList<String> queue = new LinkedList<String>();

        Hashtable<String, String> hashtable = HttpParser.parseFileAndDir(new URL(DownloadConstants.startURL));
        parseHash(queue, hashtable);

        while(!queue.isEmpty()){
            String urlPath = queue.pop();
            Hashtable<String, String> hashtable1 = HttpParser.parseFileAndDir(new URL(urlPath));
            parseHash(queue, hashtable1);
        }
        ZDSLogger.getInstance().close();
    }

    public void parseHash(LinkedList<String> queue, Hashtable<String, String> hashtable){
       Set<Map.Entry<String, String>> entry = hashtable.entrySet();
       for(Map.Entry<String, String> e : entry){
           if(isDir(e.getKey())){
               queue.push(e.getValue());
           } else{
               try {
                   if(e.getValue().equals("../")) continue;
                   new Thread(new DownloadTask(new URL(e.getValue()), DownloadConstants.basePath + e.getValue().replaceAll("http://10.45.241.159:8081/nexus/content/repositories/releases/com/", ""))).start();

               } catch (MalformedURLException e1) {
                   System.err.println(e.getValue());
                   e1.printStackTrace();
               }
           }
       }
    }

    public boolean isDir(String s){
        if(s.endsWith("/")) return true;
        else return false;
    }
    public static void main(String[] args) throws IOException {
//        String baseURL = "http://10.45.241.159:8081/nexus/content/repositories/releases/com/alib";
//        System.out.println(baseURL.substring(0, baseURL.lastIndexOf("/")));
//
//        System.out.println(baseURL.replaceAll("http://10.45.241.159:8081/nexus/content/repositories/releases/com/", ""));
////        URL url = new URL(baseURL);
////        url.openConnection();
////        BufferedInputStream bufferedInputStream = new BufferedInputStream()
////        System.out.println(url.getContent());
//
////        String s = "asdqeqw";
////        System.out.println(s.indexOf("sd"));
////        System.out.println(s.indexOf("ds"));
//        File file = new File("E:\\http_download_files\\wangyin\\sdf");
//        if(!file.exists())
//            if(file.mkdir()){
//                System.out.println("created");
//            } else{
//                System.out.println("failed.");
//            }
        new Main().start();
    }
}
