package design.patterns.observer.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2020-05-22 4:07 下午 周五
 */
@Configuration
@ComponentScan
@EnableAsync
public class AppConfig {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        configApplicationContext.getBean(Service.class).publish3();
    }
}
