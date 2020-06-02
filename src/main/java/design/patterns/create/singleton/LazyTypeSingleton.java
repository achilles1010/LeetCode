package design.patterns.create.singleton;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2020-05-26 11:17 上午 周二
 */
public class LazyTypeSingleton {

    /**
     * volatile 关键字修改 防止指令重拍
     */
    private volatile static App app = null;

    /**
     * Double Check Lock (DCL) 双重锁校验
     */
    static App getInstanceByDcl() {
        if (null == app) {
            synchronized (LazyTypeSingleton.class) {
                if (null == app) {
                    System.out.println("App - 饿汉模式DCL 双重锁校验");
                    return new App();
                }
            }
        }

        return app;
    }
}
