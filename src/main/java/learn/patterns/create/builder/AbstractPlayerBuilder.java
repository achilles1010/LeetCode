package learn.patterns.create.builder;

/**
 * The type Abstract player builder.
 *
 * @author daixulin
 * @version : v1.0
 * @date 2020 -06-05 4:54 下午 周五
 */
public abstract class AbstractPlayerBuilder {
    /**
     * The Player.
     */
    protected MusicPlayer player = new MusicPlayer();

    /**
     * Build type.
     */
    public  abstract void buildType();

    /**
     * Build menu.
     */
    public  abstract void buildMenu();

    /**
     * Build player list.
     */
    public  abstract void buildPlayerList();

    /**
     * Build main windows.
     */
    public  abstract void buildMainWindows();

    /**
     * Build control strip.
     */
    public  abstract void buildControlStrip();

    /**
     * Build collection list.
     */
    public  abstract void buildCollectionList();

    /**
     * Create player music player.
     *
     * @return the music player
     */
    public MusicPlayer createPlayer() {
        return player;
    }
}
