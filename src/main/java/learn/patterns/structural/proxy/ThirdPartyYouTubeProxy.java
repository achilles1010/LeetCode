package learn.patterns.structural.proxy;

import java.util.HashMap;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2020-06-02 3:22 下午 周二
 */
public class ThirdPartyYouTubeProxy implements ThirdPartyYouTubeLib{
    private HashMap<String, Video> cachePopular = new HashMap<>();
    private HashMap<String, Video> cacheAll = new HashMap<>();

    private ThirdPartyYouTubeLib youTubeService;
    public ThirdPartyYouTubeProxy() {
        this.youTubeService = new ThirdPartyYouTubeClass();
    }

    @Override
    public HashMap<String, Video> popularVideos() {
        if (cachePopular.isEmpty()) {
            cachePopular = youTubeService.popularVideos();
        } else {
            System.out.println("Retrieved list from cache");
        }

        return cachePopular;
    }

    @Override
    public Video getVideo(String videoId) {
        Video video = cacheAll.get(videoId);
        if (video == null) {
            video = youTubeService.getVideo(videoId);
            cacheAll.put(videoId, video);
        } else {
            System.out.println("Retrieved video '" + videoId + "' from cache.");
        }

        return video;
    }

    public void reset() {
        cachePopular.clear();
        cacheAll.clear();;
    }
}
