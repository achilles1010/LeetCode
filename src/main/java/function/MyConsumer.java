package function;

import java.util.function.Consumer;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2020-06-04 5:00 下午 周四
 */
public class MyConsumer {

    public static void main(String[] args) {
        Foo f = new Foo();
        f.foo(System.out::println);
    }

    static class Foo {
        private int[] data = new int[10];

        public Foo() {
            for (int i = 0; i < 10; i++) {
               data[i] = i;
            }
        }

        public void foo(Consumer<Integer> consumer) {
            for (int i : data) {
                consumer.accept(i);
            }
        }
    }
}
