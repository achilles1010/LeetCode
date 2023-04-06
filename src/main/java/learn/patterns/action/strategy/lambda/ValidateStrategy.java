package learn.patterns.action.strategy.lambda;

/**
 * The interface Pay strategy.
 *
 * @author daixulin
 * @version : v1.0
 * @date 2020 -06-03 10:45 上午 周三
 */
public interface ValidateStrategy {
    /**
     * Execute boolean.
     *
     * @param s the s
     * @return the boolean
     */
    boolean execute(String s);
}
