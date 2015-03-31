package zds.observer_pattern;

/**
 * Created by wyzhangdongsheng1 on 2014/10/20.
 */
public abstract class Observer {
    protected Subject subject;
    public Observer(Subject subject){
        this.subject = subject;
        subject.attach(this);
    }
    public abstract void update();
}
