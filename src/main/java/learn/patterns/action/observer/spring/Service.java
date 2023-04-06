package learn.patterns.action.observer.spring;

import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2020-05-22 4:07 下午 周五
 */
@Component
@AllArgsConstructor
public class Service {

    private final MyEventPublish myEventPublish;

    public void publish() {
       this.myEventPublish.publish(new MyEvent(this, "v1", false));
    }

    @Resource
    ApplicationContext applicationContext;

    public void publish2() {
        applicationContext.publishEvent(new MyEvent(this, "v2", false));
    }

    public void publish3() {
        applicationContext.publishEvent(new MyEvent(this, "v2", true));
    }
}
