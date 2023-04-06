package learn.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2021-03-11 下午3:54 周四
 */
@Configuration
@ComponentScan(basePackages = "bean")
public class BeanLifeCycleConfig {

    @Bean(initMethod = "myInit", destroyMethod = "myDestroy")
    @Scope(value = "singleton")
    public Person person() {
        System.out.println("myInit实例化开始");
        Person p = new Person();
        p.setName("dxl");
        p.setAddress("beijing");
        p.setPhone(156);
        return p;
    }
}
