package design.patterns.observer.spring;

import org.springframework.context.ApplicationEvent;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2020-05-22 4:08 下午 周五
 */
public class MyEvent extends ApplicationEvent {
    private final String content;
    private final boolean sendEmail;

    public MyEvent(Object source, String content,  boolean sendEmail) {
        super(source);
        this.content = content;
        this.sendEmail = sendEmail;
    }

    public String getContent() {
        return content;
    }

    public boolean isSendEmail() {
        return sendEmail;
    }
}
