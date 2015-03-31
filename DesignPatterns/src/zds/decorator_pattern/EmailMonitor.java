package zds.decorator_pattern;

/**
 * Created by wyzhangdongsheng1 on 2014/11/3.
 */
public class EmailMonitor extends LoggerMonitorFilter {
    public EmailMonitor(Monitor monitor) {
        super(monitor);
    }

    @Override
    public void handle() {
        monitor.handle();
        System.out.println("邮件通知.");
    }
}
