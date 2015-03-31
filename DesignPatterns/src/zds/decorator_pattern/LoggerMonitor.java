package zds.decorator_pattern;

import java.io.InputStream;

/**
 * Created by wyzhangdongsheng1 on 2014/11/3.
 */
public class LoggerMonitor implements Monitor {
    @Override
    public void handle() {
        System.out.println("日志已记录.");
    }
}
