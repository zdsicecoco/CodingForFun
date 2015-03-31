package zds.decorator_pattern;

/**
 * Created by wyzhangdongsheng1 on 2014/11/3.
 */
public class LoggerMonitorFilter extends LoggerMonitor{
    protected Monitor monitor;

    public LoggerMonitorFilter(Monitor monitor){
        this.monitor = monitor;
    }

    @Override
    public void handle() {
        monitor.handle();
    }
}
