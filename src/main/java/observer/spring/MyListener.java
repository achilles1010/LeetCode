package observer.spring;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2020-05-22 4:07 下午 周五
 */
@Component
public class MyListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
//        System.out.println("refresh:"+contextRefreshedEvent.getTimestamp());
    }
}
