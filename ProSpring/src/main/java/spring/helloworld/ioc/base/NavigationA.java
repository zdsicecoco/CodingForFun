package spring.helloworld.ioc.base;

/**
 * Created by wyzhangdongsheng1 on 14-11-28.
 */
public class NavigationA {
    private NavigationB navigationB;

    public void setNavigationB(NavigationB navigationB) {
        this.navigationB = navigationB;
    }

    public NavigationB getNavigationB() {
        return navigationB;
    }
}
