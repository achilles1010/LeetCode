package design.patterns.action.observer;

import java.io.File;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2020-05-22 2:34 下午 周五
 */
public class EmailNotificationListener implements EventListener{
    private String email;

    public EmailNotificationListener(String email) {
        this.email = email;
    }

    @Override
    public void update(String eventType, File file) {
        System.out.println(("Email to " + email + ": Someone has performed" + eventType + " operation with the following file:" + file.getName()));
    }
}
