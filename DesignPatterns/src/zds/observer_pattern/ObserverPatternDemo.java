package zds.observer_pattern;

/**
 * Created by wyzhangdongsheng1 on 2014/10/20.
 */
public class ObserverPatternDemo {
    public static void main(String[] args) {
        Subject subject = new Subject(5);
        new BinaryObserver(subject);
        new OctalObserver(subject);
        new HexaObserver(subject);

        subject.setState(10);

        subject.setState(8);

        subject.setState(114);
    }
}
