package design.patterns.state;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2020-04-26 10:32 上午 周日
 */
public abstract class State {
    Player player;

    /**
     * Context passes itself through the state constructor. This may help a
     * state to fetch some useful context data if needed.
     */
    State(Player player) {
        this.player = player;
    }

    public abstract String onLock();
    public abstract String onPlay();
    public abstract String onNext();
    public abstract String onPrevious();
}
