package bean;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2021-03-11 下午3:54 周四
 */
public class BeanLifeCycle {

    @Test
    public void test() {
        System.out.println("test1>>>现在开始初始化容器");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanLifeCycleConfig.class);
        System.out.println("test2>>>容器初始化成功");
        Person p = context.getBean("person", Person.class);
        System.out.println(p);
        System.out.println("test3>>>现在开始关闭容器！");
        context.registerShutdownHook();
    }
}
