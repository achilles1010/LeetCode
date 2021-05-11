package proxy.jdk;

import org.junit.Test;

/**
 * @author daixulin
 * @version : v1.0
 * @project :LeetCode
 * @create 2021-04-16 下午1:39 周五
 */
public class ProxyTest {

    @Test
    public void contextTest() {
        // 实例化目标对象
        UserService userService = new UserServiceImp();

        // 实例化 InvocationHandler 传入代理接口实现
        MyInvocationHandler invocationHandler = new MyInvocationHandler(userService);

        // 生成代理对象
//        UserService proxy = (UserService) invocationHandler.getProxy();
        UserService proxy = (UserService) JdkProxyFactory.getProxy(userService);

        // 调用代理对象的方法
        proxy.add();
        proxy.delete();
    }
}
