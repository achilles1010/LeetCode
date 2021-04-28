package base.juc;

import lombok.SneakyThrows;

import java.util.concurrent.CyclicBarrier;

/**
 * @author daixulin
 * @version : v1.0
 * @project :LeetCode
 * @create 2021-04-06 下午4:01 周二
 */
public class TestCyclicBarrier {

    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("线程组任务开始");
            }
        });

        for (int i = 0; i < 5 ; i++) {
            new Thread(new readNum(i, cyclicBarrier)).start();
        }

    }

    public static class readNum implements Runnable {
        private int id;
        private CyclicBarrier cyclicBarrier;

        public readNum(int id, CyclicBarrier cyclicBarrier) {
            this.id = id;
            this.cyclicBarrier = cyclicBarrier;
        }

        @SneakyThrows
        @Override
        public void run() {
            synchronized (this) {
               System.out.println("id:"+id);
               cyclicBarrier.await();
               System.out.println("线程组任务:"+id+"结束,其他任务继续");
           }
        }
    }
}
