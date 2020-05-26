package observer;

import java.io.File;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2020-05-22 2:34 下午 周五
 */
public class LogOpenListener implements EventListener{
    private File log;

    public LogOpenListener(String fileName) {
        this.log =  new File(fileName);
    }

    @Override
    public void update(String eventType, File file) {
        System.out.println(("Save to log " + log + ": Someone has performed" + eventType + " operation with the following file:" + file.getName()));
    }
}
