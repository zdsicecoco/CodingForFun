package ClassLoadSystem;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by wyzhangdongsheng1 on 15-1-31.
 */
public class ReflectionCompare {
    private static final int WARMUP_COUNT = 10700;
    private ForReflection testClass = new ForReflection();
    private static Method method = null;

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        method = ForReflection.class.getMethod("execute", new Class<?>[]{String.class});
        ReflectionCompare demo = new ReflectionCompare();
        //保证反射能生成字节码及相关的测试代码能够被JIT编译
        for(int i = 0; i < 20; i++){
            demo.testDirectCall();
            demo.testCacheMethodCall();
            demo.testNoCacheMethodCall();
        }

        long beginTime = System.currentTimeMillis();
        demo.testDirectCall();
        long entTime = System.currentTimeMillis();
        System.out.println("直接调用消耗的时间为：" + (entTime - beginTime) + "毫秒");
        beginTime = System.currentTimeMillis();
        demo.testNoCacheMethodCall();
        entTime = System.currentTimeMillis();
        System.out.println("不缓存Method，反射调用消耗的时间为：" + (entTime - beginTime) + "毫秒");
        beginTime = System.currentTimeMillis();
        demo.testDirectCall();
        entTime = System.currentTimeMillis();
        System.out.println("缓存Method，反射调用消耗的时间为：" + (entTime - beginTime) + "毫秒");

    }

    public void testDirectCall(){
        for(int i = 0; i < WARMUP_COUNT; i++){
            testClass.execute("hello");
        }
    }

    public void testCacheMethodCall() throws InvocationTargetException, IllegalAccessException {
        for (int i = 0; i < WARMUP_COUNT; i++) {
            method.invoke(testClass, new Object[]{"hello"});
        }
    }

    public void testNoCacheMethodCall() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        for (int i = 0; i < WARMUP_COUNT; i++) {
            Method testMethod = ForReflection.class.getMethod("execute", String.class);
            testMethod.invoke(testClass, new Object[]{"hello"});
        }
    }
}
