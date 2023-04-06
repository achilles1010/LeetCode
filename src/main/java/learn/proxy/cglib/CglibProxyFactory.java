package learn.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2021-05-11 下午4:42 周二
 */
public class CglibProxyFactory {
    public static Object getProxy(Class<?> clazz) {
        Enhancer  enhancer = new Enhancer();
        enhancer.setClassLoader(clazz.getClassLoader());
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(new MethodInterceptorImpl());
        return enhancer.create();
    }
}
