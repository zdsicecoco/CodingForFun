package spring.helloworld.ioc.base;

import java.io.IOException;

/**
 * Created by wyzhangdongsheng1 on 14-11-28.
 */
public class DependentBean {
    ResouceBean resouceBean;

    public void write(String ss) throws IOException{
        System.out.println("DependentBean:=============写资源");
        resouceBean.getFileOutputStream().write(ss.getBytes());
    }

    public void init() throws IOException {
        System.out.println("DependentBean:=============初始化");
        resouceBean.getFileOutputStream().write("DependentBean:=============初始化".getBytes());
    }

    public void destroy() throws IOException {
        System.out.println("DependentBean:=============销毁");
        resouceBean.getFileOutputStream().write("DependentBean:=============销毁".getBytes());
    }

    public void setResouceBean(ResouceBean resouceBean){
        this.resouceBean = resouceBean;
    }
}
