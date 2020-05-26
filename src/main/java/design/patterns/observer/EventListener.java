package design.patterns.observer;

import java.io.File;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2020-05-22 2:42 下午 周五
 */
public interface EventListener {
   void update(String eventType, File file);
}
