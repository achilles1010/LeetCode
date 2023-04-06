package learn.juc;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2021-03-18 上午10:38 周四
 */
public class CountDownLatchEg {
    private static final int THREAD_COUNT = 6;

    private static final Integer N_CPUS = Runtime.getRuntime().availableProcessors();
    private static final Integer THREAD_KEEP_ALIVE_SECONDS = 50;

    public static ThreadPoolTaskExecutor taskExecutor() {
        //线程创建流程:
        //1.当线程数量小于corePoolSize时，创建线程，不管线程是不是闲置的
        //2.当线程数量大于等于corePoolSize时，把任务放到queueCapacity队列
        //3.当queueCapacity满了，就创建新的线程来执行
        //4.当线程数量大于等于maxPoolSize时，根据RejectedExecutionHandler设置的策略来处理新加入的任务
        //5.当线程池中的线程数量大于corePoolSize时，如果某线程空闲时间超过keepAliveTime，线程将被终止。这样，线程池可以动态的调整池中的线程数。


        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        // 设置最小线程数=CPU核数
        taskExecutor.setCorePoolSize(N_CPUS);
        // 设置最大线程数
        taskExecutor.setMaxPoolSize(2 * N_CPUS);
        // 设置(maxPoolSize-corePoolSize)部分线程空闲最大存活时间
        taskExecutor.setKeepAliveSeconds(THREAD_KEEP_ALIVE_SECONDS);
        // 当提交任务数超过maxPoolSize+workQueue之和时，任务会交给RejectedExecutionHandler来处理
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        taskExecutor.initialize();

        return taskExecutor;
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor taskExecutor = taskExecutor().getThreadPoolExecutor();

        final CountDownLatch countDownLatch = new CountDownLatch(THREAD_COUNT);

        for (int i = 0; i < THREAD_COUNT; i++) {
           final int threadNum = i;
            taskExecutor.execute(()->{
               try {
                   System.out.println("threadNum:"+ threadNum);
                   TimeUnit.SECONDS.sleep(1);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               } finally {
                   countDownLatch.countDown();
               }
           });
        }

        countDownLatch.await();
        taskExecutor.shutdown();
        System.out.println("finish");
    }
}
