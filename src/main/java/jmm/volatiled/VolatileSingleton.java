package jmm.volatiled;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2021-03-17 下午4:03 周三
 */
public class VolatileSingleton {
    private static VolatileSingleton instance = null;

    private VolatileSingleton() {
        System.out.println(Thread.currentThread().getName() + "\t 我是构造方法SingletonDemo");
    }

    public static VolatileSingleton getInstance() {
        if (instance == null) {
            synchronized (VolatileSingleton.class) {
                if (instance == null) {
                    instance = new VolatileSingleton();
                }
            }
        }

        return instance;
    }


}
