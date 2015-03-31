package zds.observer_pattern;

/**
 * Created by wyzhangdongsheng1 on 2014/10/20.
 */
public class BinaryObserver extends Observer{

    public BinaryObserver(Subject subject) {
        super(subject);
    }

    @Override
    public void update() {
        System.out.println("BinaryObserver:" + Integer.toBinaryString(subject.getState()));
    }
}
