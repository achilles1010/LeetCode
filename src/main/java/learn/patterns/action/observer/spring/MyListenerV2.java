package learn.patterns.action.observer.spring;

import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2020-05-22 4:07 下午 周五
 */
@Component
public class MyListenerV2 {

    @Async
    @EventListener
    @Order(100)
    public void onTestEvent(MyEvent myEvent) {
        System.out.println("test2 event listener :"+myEvent.getTimestamp());
    }
}
