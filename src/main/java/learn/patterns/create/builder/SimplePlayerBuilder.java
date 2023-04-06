package learn.patterns.create.builder;

/**
 * The type Abstract player builder.
 *
 * @author daixulin
 * @version : v1.0
 * @date 2020 -06-05 4:54 下午 周五
 */
public class SimplePlayerBuilder extends AbstractPlayerBuilder{

    @Override
    public void buildType() {
        player.setType("精简模式");
    }
    @Override
    public void buildMenu() {
        player.setMenu(null);
    }
    @Override
    public void buildPlayerList() {
        player.setPlayerList(null);
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
        player.setCollectionList(null);
    }
}
