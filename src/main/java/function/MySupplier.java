package function;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Supplier;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2020-06-04 5:00 下午 周四
 */
public class MySupplier {
    public static void main(String[] args) {
        Supplier<Integer> supplier = () -> new Random().nextInt(100);

        int[] ints = new int[10];
        for (int i = 0; i < 10; i++) {
            ints[i] = supplier.get();
        }

        Arrays.stream(ints).forEach(System.out::println);
   }
}
