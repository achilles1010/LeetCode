package learn.function;

import java.util.function.Function;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2020-06-04 5:00 下午 周四
 */
public class MyFunction implements Function<String, Integer> {
    @Override
    public Integer apply(String s) {
        return s.length();
    }
}
