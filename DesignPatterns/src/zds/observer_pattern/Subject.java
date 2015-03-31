package zds.observer_pattern;

import java.util.ArrayList;

/**
 * Created by wyzhangdongsheng1 on 2014/10/20.
 */
public class Subject {
    private ArrayList<Observer> observers = new ArrayList<Observer>();
    private int state;

    public Subject(int state){
        this.state = state;
    }
    public int getState(){
        return state;
    }

    public void setState(int state){
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void notifyAllObservers(){
        for(Observer observer : observers){
            observer.update();
        }
    }
}
