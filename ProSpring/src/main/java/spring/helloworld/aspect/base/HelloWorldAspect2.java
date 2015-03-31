package spring.helloworld.aspect.base;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.jdbc.datasource.DataSourceUtils;

/**
 * Created by wyzhangdongsheng1 on 14-12-3.
 */
@Aspect
public class HelloWorldAspect2 {
    @Pointcut(value = "execution(* spring.helloworld.aspect.base.*.sayAdvisorBefore(..)) && args(param)", argNames = "param")
    public void beforePointcut(String param){}

    @Before(value = "beforePointcut(param)", argNames = "param")
    public void beforeAdvice(String param){
        System.out.println("======================before advice param:" + param);
    }

    @AfterReturning(value = "execution(* spring.hellowold.aspect.base.*.sayBefore(..))", pointcut = "execution(* spring.helloworld.aspect.base.*.sayAfterReturning(..))", argNames = "retVal", returning="retVal")
    public void afterReturningAdvice(Object retVal){
        System.out.println("======================after returning advice retVal:" + retVal);
    }

    public static void main(String[] args) {

    }
}
