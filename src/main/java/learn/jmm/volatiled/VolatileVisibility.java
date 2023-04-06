package learn.jmm.volatiled;

import java.util.concurrent.TimeUnit;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2021-03-17 下午4:03 周三
 */
public class VolatileVisibility {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            shareData.setNumberTo100();

            System.out.println(Thread.currentThread().getName() + "\t update number value " + shareData.number);

        }).start();

        while (shareData.number == 0) {

        }

        System.out.println(Thread.currentThread().getName() + "\t 主线程感知到了 number 不等于 0");

    }
}
