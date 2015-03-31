package zds.observer_pattern;

/**
 * Created by wyzhangdongsheng1 on 2014/10/20.
 */
public class OctalObserver extends Observer {
    public OctalObserver(Subject subject) {
        super(subject);
    }

    @Override
    public void update() {
        System.out.println("OctalObserver:" + Integer.toOctalString(subject.getState()));
    }
}
