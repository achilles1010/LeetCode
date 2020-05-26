package generic;

/**
 * ？ 表示不确定的 java 类型
 * T (type) 表示具体的一个java类型
 * K V (key value) 分别代表java键值中的Key Value
 * E (element) 代表Element
 * @author daixulin
 * @version : v1.0
 * @date 2020-05-26 11:43 上午 周二
 */
public class Generics {

    public static void main(String[] args) {
        // 泛型类
        Generic<Integer> generic = new Generic<>(12);
        System.out.println(generic.getKey());

        // 泛型方法
        Integer[] intArray = {1, 2, 3};
        printArray(intArray);
        String[] strArray = {"abc", "efg"};
        printArray(strArray);
    }

    /**
     * 泛型类
     * @param <T>
     */
    public static class Generic<T> {
        private T key;

        public Generic(T key) {
            this.key = key;
        }

        public T getKey() {
            return key;
        }
    }

    /**
     * 泛型接口
     * @param <T>
     */
    public interface Generator<T> {
        public T method();
    }

    /**
     * 实现泛型接口，不指定类型
     * @param <T>
     */
    static class GeneratorImpl<T> implements Generator<T> {
        @Override
        public T method() {
            return null;
        }
    }

    /**
     * 实现泛型接口，指定类型
     * @param <T>
     */
    static class GeneratorImplV2<T> implements Generator<String> {
        @Override
        public String method() {
            return "hello";
        }
    }

    /**
     * 泛型方法
     * @param inputArray 参数名
     * @param <E> 泛型
     */
    public static <E> void printArray(E[] inputArray) {
        for (E element : inputArray) {
            System.out.printf("%s", element);
        }
        System.out.println();
    }
}
