package proxy.jdk;

import java.lang.reflect.Proxy;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2021-05-11 下午4:36 周二
 */
public class JdkProxyFactory {
    public static Object getProxy(Object target) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new MyInvocationHandler(target)
        );
    }
}
