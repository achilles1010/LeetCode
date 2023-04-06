package learn.jmm.volatiled;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 演示volatile 不保证原子性
 * @author daixulin
 * @version : v1.0
 * @date 2021-03-17 下午4:03 周三
 */
public class VolatileAtomicity {

   public static volatile int number = 0;
   public static AtomicInteger atomicInteger = new AtomicInteger();

   public
//   synchronized
   static void increase() {
       number++;
   }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            new Thread(()->{
                for (int j = 1; j <= 1000; j++) {
                   increase();
//                    atomicInteger.incrementAndGet();
                }
            }, String.valueOf(i)).start();
        }

        // 当所有累加线程都结束
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }

        System.out.println(number);
//        System.out.println(atomicInteger.get());
    }
}
