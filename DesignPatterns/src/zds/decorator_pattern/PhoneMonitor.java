package zds.decorator_pattern;

/**
 * Created by wyzhangdongsheng1 on 2014/11/3.
 */
public class PhoneMonitor extends LoggerMonitorFilter{
    public PhoneMonitor(Monitor monitor) {
        super(monitor);
    }

    @Override
    public void handle() {
        monitor.handle();
        System.out.println("电话通知.");
    }
}
