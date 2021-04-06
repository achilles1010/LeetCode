package juc;

import java.util.concurrent.CountDownLatch;

/**
 * @author daixulin
 * @version : v1.0
 * @project :LeetCode
 * @create 2021-04-06 下午4:01 周二
 */
public class TestCountDown {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(5);
        for (int i = 0; i < 5 ; i++) {
            new Thread(new readNum(i, latch)).start();
        }

        latch.await();
        System.out.println("线程执行结束");
    }

    public static class readNum implements Runnable {
        private int id;
        private CountDownLatch latch;

        public readNum(int id, CountDownLatch latch) {
            this.id = id;
            this.latch = latch;
        }

        @Override
        public void run() {
           synchronized (this) {
               System.out.println("线程组任务:"+id+"结束,其他任务继续");
               latch.countDown();
           }
        }
    }
}
