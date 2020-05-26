package juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2020-05-22 1:48 下午 周五
 */
public class CountDownLatchModule {
    private static int N = 10;

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(N);

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0 ; i < N; i++) {
            executorService.execute(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " do something!");
                } catch (Exception e) {
                    System.out.println("Exception: do something exception");
                } finally {
                    //该线程执行完毕-1
                    countDownLatch.countDown();
                }
            });
        }


        System.out.println("main thread do something -1");

        int countDownLatchTimeout = 5;
        try {
            countDownLatch.await(countDownLatchTimeout, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            System.out.println("Exception: await interrupted exception");
        } finally {
            System.out.println("countDownLatch: " + countDownLatch.toString());
        }

        System.out.println("main thread do something -2");
    }
}
