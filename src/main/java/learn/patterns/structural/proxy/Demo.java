package learn.patterns.structural.proxy;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2020-06-02 3:22 下午 周二
 */
public class Demo {
    public static void main(String[] args) {
        YouTubeDownloader naiveDownloader = new YouTubeDownloader(new ThirdPartyYouTubeClass());
        YouTubeDownloader smartDownloader = new YouTubeDownloader(new ThirdPartyYouTubeProxy());

        System.out.println("time saved caching proxy:" + (test(naiveDownloader) - test(smartDownloader)) + "ms");
    }

    private static long test(YouTubeDownloader youTubeDownloader) {
        long startTime = System.currentTimeMillis();

        // 第一次加装
        youTubeDownloader.renderPopularVideos();
        youTubeDownloader.renderVideoPage("catzzzzzzzzz");
        // 第二次加载 proxy读缓存 class 从新加载
        youTubeDownloader.renderPopularVideos();
        youTubeDownloader.renderVideoPage("dancesvideoo");


        youTubeDownloader.renderVideoPage("catzzzzzzzzz");
        youTubeDownloader.renderVideoPage("someothervid");

        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("Time elapsed:" + estimatedTime + "ms");
        return estimatedTime;
    }


}
