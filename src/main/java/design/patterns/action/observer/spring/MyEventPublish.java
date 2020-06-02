package design.patterns.action.observer.spring;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2020-05-22 4:08 下午 周五
 */
@Component
public class MyEventPublish implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void publish(Object object) {
        this.applicationEventPublisher.publishEvent(object);
    }
}
