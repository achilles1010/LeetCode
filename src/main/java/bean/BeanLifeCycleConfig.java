package bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2021-03-11 下午3:54 周四
 */
@Configuration
public class BeanLifeCycleConfig {

    @Bean(initMethod = "myInit", destroyMethod = "myDestory")
    @Scope(value = "singleton")
    public Person person() {
//        Person p = new Person("dxl", "beijing", 156);
//        p.setName("dxl");
//        p.setAddress("beijing");
//        p.setPhone(156);

        Person p = new Person();
        p.setName("dxl");
        p.setAddress("beijing");
        p.setPhone(156);
        return p;
    }

}
