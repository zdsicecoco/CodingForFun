package spring.helloworld.aspect.base;

/**
 * Created by wyzhangdongsheng1 on 14-12-3.
 */
public class IntroductionService implements IIntroductionService {
    @Override
    public void induct() {
        System.out.println("======================introduction");
    }
}
