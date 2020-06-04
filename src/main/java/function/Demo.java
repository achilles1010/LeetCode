package function;

import java.util.function.Function;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2020-06-04 5:00 下午 周四
 */
public class Demo {
    private static String hello = "Nice to meet you";
    private static String name = "my name is huohuo";

    public static void main(String[] args) {
        MyFunction myFunction = new MyFunction();
        MyBiFunction myBiFunction = new MyBiFunction();

        int num = myFunction.apply(hello);
        String value = myBiFunction.apply(hello, name);
        System.out.println(num);
        System.out.println(value);

        Function<Integer, Integer> name = e -> e * 2;
        Function<Integer, Integer> square = e -> e * e;

        int value2 = name.andThen(square).apply(3);
        System.out.println(value2);

        int value3 = name.compose(square).apply(3);
        System.out.println(value3);

        Object identity = Function.identity().apply("huohuo");
        System.out.println(identity);
    }
}
