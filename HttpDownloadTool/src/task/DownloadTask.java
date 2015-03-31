package task;

import constants.DownloadConstants;
import logger.ZDSLogger;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Stack;

/**
 * Created by wyzhangdongsheng1 on 2014/10/28.
 */
public class DownloadTask implements Runnable {
    private URL url;
    private String localFilename;

    public DownloadTask(URL url, String localFilename) {
        this.url = url;
        this.localFilename = localFilename;
    }

    public void downloadFromUrl(URL url, String localFilename) {
        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            URLConnection urlConnection = url.openConnection();
            inputStream = urlConnection.getInputStream();

            String fileDir = localFilename.substring(0, localFilename.lastIndexOf("/"));
            File file = new File(fileDir);
            if (!file.exists()) {
                Stack<String> stack = new Stack<String>();
                stack.push(fileDir);
                String dir = fileDir.substring(0, fileDir.lastIndexOf("/"));
                while (!new File(dir).exists()) {
                    stack.push(dir);
                    int index = dir.lastIndexOf("/");
                    if (index == -1) break;
                    dir = dir.substring(0, index);
                }
                while (!stack.isEmpty()) {
                    dir = stack.pop();
                    new File(dir).mkdir();
                }

            }
            fileOutputStream = new FileOutputStream(localFilename);

            byte[] buffer = new byte[4096];
            int len;

            while ((len = inputStream.read(buffer)) > 0) {
                fileOutputStream.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }

    @Override
    public void run() {
        ZDSLogger logger = ZDSLogger.getInstance();
        if (url != null && localFilename != null && !localFilename.equals("")) {
            downloadFromUrl(url, localFilename);
            logger.appendLogger("Suc:" + url.getPath() + "###" + localFilename + "\n");
        } else {
            logger.appendLogger("Err:" + url.getPath() + "###" + localFilename + "\n");
        }
    }

    public static void main(String[] args) {
        try {
            new Thread(new DownloadTask(new URL("http://10.45.241.159:8081/nexus/content/repositories/releases/com/alibaba/dubbo/2.4.10.1-wy/dubbo-2.4.10.1-wy.jar"), DownloadConstants.basePath + "dubbo-2.4.10.1-wy.jar")).start();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
