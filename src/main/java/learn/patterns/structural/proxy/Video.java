package learn.patterns.structural.proxy;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2020-06-02 3:22 下午 周二
 */
public class Video {
    public String id;
    public String title;
    public String data;
    Video(String id, String title) {
        this.id = id;
        this.title = title;
        this.data = "Random video.";
    }
}
