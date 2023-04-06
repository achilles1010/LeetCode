package learn.function;

import java.util.function.Predicate;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2020-06-04 5:00 下午 周四
 */
public class MyPredicate {
    public static void main(String[] args) {
        Predicate<Integer> predicate = integer -> integer <= 0;
        Predicate<Integer> predicate1 = integer -> integer > 0;

        System.out.println("and ：" + predicate.and(predicate1).test(1));
        System.out.println("or : " + predicate.or(predicate1).test(1));
        System.out.println("negate : " + predicate.negate().test(1));
        System.out.println("normal : " + predicate.test(1));
    }
}
