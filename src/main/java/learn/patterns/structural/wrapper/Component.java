package learn.patterns.structural.wrapper;

import java.util.function.Function;

/**
 * The type Component.
 *
 * @author daixulin
 * @version : v1.0
 * @date 2020 -06-05 5:21 下午 周五
 */
public abstract class Component implements Function<String, String> {
    /**
     * Operation.
     */
    public abstract void operation();
}
