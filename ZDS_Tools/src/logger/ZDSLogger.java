package logger;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 * Created by wyzhangdongsheng1 on 2014/10/30.
 */
public class ZDSLogger {
    private PrintWriter printWriter;
    private static ZDSLogger logger;
    private static String basePath = "";
    private static String filename = "";
    private ZDSLogger(){
        try {
            printWriter = new PrintWriter(new FileOutputStream(basePath + filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static ZDSLogger getInstance(){
        if(ZDSLogger.logger == null)
            logger = new ZDSLogger();
        return logger;
    }

    public void appendLogger(String s){
        printWriter.append(s);
    }

    public void close(){
        if(printWriter != null)
            printWriter.close();
    }

}
