package zds.observer_pattern;

/**
 * Created by wyzhangdongsheng1 on 2014/10/20.
 */
public class HexaObserver extends Observer {
    public HexaObserver(Subject subject) {
        super(subject);
    }

    @Override
    public void update() {
        System.out.println("HexaObserver:" + Integer.toHexString(subject.getState()));
    }
}
