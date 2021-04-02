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

        // 1. Person 构造器
        // 2. 调用Person属性 setter方法
        // 3. 调用BeanNameAware.setBeanName()
        // 4. 调用BeanFactoryAware.setBeanFactory()
        // 5. 调用ApplicationContext.setApplicationContext()方法
        // 调用BeanPostProcessor.postProcessBeforeInitialization方法

        // 6. 调用InitializingBean.afterPropertiesSet()
        // 7. 调用自定义的init-method方法

        // 调用BeanPostProcessor.postProcessBeforeInitialization方法

        // 8. 调用DisposableBean.destroy()
        // 9. 调用自定义的destroy-method属性指定的初始化方法

        System.out.println(p);
        System.out.println("test3>>>现在开始关闭容器！");
//        context.registerShutdownHook();
//        context.close();
    }
}
