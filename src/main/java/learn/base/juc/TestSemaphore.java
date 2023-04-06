package learn.base.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author daixulin
 * @version : v1.0
 * @project :LeetCode
 * @create 2021-04-06 下午4:01 周二
 */
public class TestSemaphore {

    /**
     * 根据输出结果进行分析，Semaphore 允许的最大许可数为 5，也就是允许的最大并发执行的线程个数为 5，可以看出，前 5 个线程（前 5 个学生）先获取到笔，然后填写表格，
     * 而 6-10 这 5 个线程，由于获取不到许可，只能阻塞等待。当线程pool-1-thread-4释放了许可之后，pool-1-thread-9就可以获取到许可，继续往下执行。对其他线程的执行过程，也是同样的道理。
     * 从这个例子就可以看出，Semaphore 用来做特殊资源的并发访问控制是相当合适的，如果有业务场景需要进行流量控制，可以优先考虑 Semaphore。
     */
    private static Semaphore semaphore = new Semaphore(5);

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i <  10; i++) {
            service.execute(()->{
                try {
                    System.out.println(Thread.currentThread().getName() + "  同学准备获取笔......");
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "  同学获取到笔");
                    System.out.println(Thread.currentThread().getName() + "  填写表格ing.....");
                    TimeUnit.SECONDS.sleep(3);

                    semaphore.release();
                    System.out.println(Thread.currentThread().getName() + "  填写完表格，归还了笔！！！！！！");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
