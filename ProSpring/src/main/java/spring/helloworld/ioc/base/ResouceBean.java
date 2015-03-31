package spring.helloworld.ioc.base;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by wyzhangdongsheng1 on 14-11-28.
 */
public class ResouceBean {
    private FileOutputStream fileOutputStream;
    private File file;

    public void init(){
        System.out.println("ResouceBean:==========初始化");
        System.out.println("ResouceBean:==========加载资源，执行一些预操作");
        try {
            this.fileOutputStream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void destroy(){
        System.out.println("ResouceBean:=========销毁");
        System.out.println("ResouceBean:=========释放资源，执行一些清理操作");
        try {
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public FileOutputStream getFileOutputStream() {
        return fileOutputStream;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
