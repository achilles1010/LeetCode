package design.patterns.action.observer;

import java.io.File;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2020-05-22 2:34 下午 周五
 */
public class Editor {
    public EventManager events;
    private File file;

    public Editor() {
        this.events = new EventManager("open", "save");
    }

    public void openFile(String filePath) {
        this.file = new File(filePath);
        events.notify("open", file);
    }

    public void saveFile() throws Exception {
        if (this.file != null) {
            events.notify("save", file);
        } else {
            throw new Exception("Please open a file first");
        }
    }

    public static void main(String[] args) throws Exception {
        Editor editor = new Editor();

        LogOpenListener logOpenListener =  new LogOpenListener("/User/daixulin/Desktop/1.txt");
        EmailNotificationListener emailNotificationListener = new EmailNotificationListener("123@xx.com");

        editor.events.subscribe("open", logOpenListener);
        editor.events.subscribe("save", emailNotificationListener);
        editor.openFile("test.txt");
        editor.saveFile();
        editor.events.unsubscribe("open", logOpenListener);
        editor.events.unsubscribe("save", emailNotificationListener);

    }
}
