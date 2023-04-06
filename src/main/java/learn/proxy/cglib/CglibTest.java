package learn.proxy.cglib;

import org.junit.Test;

/**
 * @author daixulin
 * @version : v1.0
 * @project :LeetCode
 * @create 2021-04-16 下午2:01 周五
 */
public class CglibTest {
    @Test
    public void test() throws ClassNotFoundException {
        //由于 Cglib 是使用继承方式，所有final类是不能使用cglib代理的，会直接抛出异常，final方法也将不会被代理，因为不能覆盖，不会直接抛出异常
//        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/daixulin/Documents/JavaConf/LeetCode/src/main/java/proxy/cglib");
//        Enhancer enhancer = new Enhancer();
//        enhancer.setSuperclass(EnhancerDemo.class);
//        enhancer.setCallback(new MethodInterceptorImpl());
//        EnhancerDemo proxy = (EnhancerDemo) enhancer.create();

        EnhancerDemo proxy = (EnhancerDemo) CglibProxyFactory.getProxy(EnhancerDemo.class);
        proxy.test();

        System.out.println(proxy);
        Class x = EnhancerDemo.class;
        Class y = Class.forName("learn.proxy.cglib.EnhancerDemo");
        EnhancerDemo enhancerDemo = new EnhancerDemo();
        Class z = enhancerDemo.getClass();
        ClassLoader classLoader = null;
//        Class f = classLoader.loadClass("proxy.cglib.EnhancerDemo");

        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
//        System.out.println(f);

    }

}
