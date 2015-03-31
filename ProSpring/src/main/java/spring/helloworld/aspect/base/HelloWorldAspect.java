package spring.helloworld.aspect.base;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Created by wyzhangdongsheng1 on 14-12-2.
 */
public class HelloWorldAspect {
    public void beforeAdvice(){
        System.out.println("============before advice");
    }

    public void beforeAdvice(String param){
        System.out.println("============before advice param:" + param);
    }

    public void afterReturningAdvice(Object retVal){
        System.out.println("============after returning advice retVal:" + retVal);
    }


    public void afterThrowingAdvice(Exception exception){
        System.out.println("============after throwing advice exception:" + exception);
    }

    public void afterFinallyAdvice(){
        System.out.println("============after finally advice");
    }

    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("============around before advice");
        Object retVal = proceedingJoinPoint.proceed(new Object[]{"replace"});
        System.out.println("============around after advice");
        return  retVal;
    }

}
