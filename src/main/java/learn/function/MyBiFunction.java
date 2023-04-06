package learn.function;

import java.util.function.BiFunction;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2020-06-04 5:00 下午 周四
 */
public class MyBiFunction implements BiFunction<String, String, String> {
    @Override
    public String apply(String s, String s2) {
        return s+";"+s2;
    }
}
