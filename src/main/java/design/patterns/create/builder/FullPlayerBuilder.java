package design.patterns.create.builder;

/**
 * The type Abstract player builder.
 *
 * @author daixulin
 * @version : v1.0
 * @date 2020 -06-05 4:54 下午 周五
 */
public class FullPlayerBuilder extends AbstractPlayerBuilder{

    @Override
    public void buildType() {
        player.setType("完整模式");
    }

    @Override
    public void buildMenu() {
        player.setMenu("菜单");
    }

    @Override
    public void buildPlayerList() {
        player.setPlayerList("播放列表");
    }

    @Override
    public void buildMainWindows() {
        player.setMainWindows("主界面");
    }

    @Override
    public void buildControlStrip() {
        player.setControlStrip("控制条");
    }

    @Override
    public void buildCollectionList() {
        player.setCollectionList("收藏列表");
    }
}
