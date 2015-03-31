package spring.helloworld.ioc.base;

/**
 * Created by wyzhangdongsheng1 on 14-11-28.
 */
public class CircleB {
    private CircleC circleC;

    public CircleB(){}

    public CircleB(CircleC circleC) {
        this.circleC = circleC;
    }

    public void setCircleC(CircleC circleC){
        this.circleC = circleC;
    }

    public void b(){
        circleC.c();
    }
}
