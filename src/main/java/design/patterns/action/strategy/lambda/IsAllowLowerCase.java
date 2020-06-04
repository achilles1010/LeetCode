package design.patterns.action.strategy.lambda;

/**
 * The interface Pay strategy.
 *
 * @author daixulin
 * @version : v1.0
 * @date 2020 -06-03 10:45 上午 周三
 */
public class IsAllowLowerCase implements ValidateStrategy {
    /**
     * Execute boolean.
     *
     * @param s the s
     * @return the boolean
     */
    @Override
    public boolean execute(String s) {
        return s.matches("[a-z]+");
    }
}
