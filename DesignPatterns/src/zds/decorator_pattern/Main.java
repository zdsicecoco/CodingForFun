package zds.decorator_pattern;

/**
 * Created by wyzhangdongsheng1 on 2014/11/3.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("###############################");
        System.out.println("log + email:");
        Monitor monitor = new EmailMonitor(new LoggerMonitor());
        monitor.handle();

        System.out.println("###############################");
        System.out.println("log + phone:");
        monitor = new PhoneMonitor(new LoggerMonitor());
        monitor.handle();

        System.out.println("###############################");
        System.out.println("log + email + phone");
        monitor = new PhoneMonitor(new EmailMonitor(new LoggerMonitor()));
        monitor.handle();
    }
}
