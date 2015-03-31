package spring.helloworld.ioc.base;

import spring.helloworld.ioc.base.CircleA;

/**
 * Created by wyzhangdongsheng1 on 14-11-28.
 */
public class CircleC {
    private CircleA circleA;

    public CircleC(){}

    public CircleC(CircleA circleA){
        this.circleA = circleA;
    }

    public void setCircleA(CircleA circleA){
        this.circleA = circleA;
    }

    public void c(){
        circleA.a();
    }
}
