package design.patterns.structural.proxy;

import java.util.HashMap;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2020-06-02 3:22 下午 周二
 */
public interface ThirdPartyYouTubeLib {
   HashMap<String, Video> popularVideos();
   Video getVideo(String videoId);
}
