package learn.jmm.volatiled;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2021-03-17 下午4:02 周三
 */
public class ShareData {
    /**
     * volatile修饰的变量成为共享变量，当某线程更新变量后，其他线程也能感知到 共享线程间变量通信
     */
    public volatile int number = 0;

    public void setNumberTo100() {
        this.number = 100;
    }
}
