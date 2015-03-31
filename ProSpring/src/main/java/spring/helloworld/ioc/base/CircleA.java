package spring.helloworld.ioc.base;

/**
 * Created by wyzhangdongsheng1 on 14-11-28.
 */
public class CircleA {
    private CircleB circleB;

    public CircleA() {
    }

    public CircleA(CircleB circleB) {
        this.circleB = circleB;
    }

    public void setCircleB(CircleB circleB){
        this.circleB = circleB;
    }

    public void a(){
        circleB.b();
    }
}
