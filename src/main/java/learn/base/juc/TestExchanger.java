package learn.base.juc;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author daixulin
 * @version : v1.0
 * @project :LeetCode
 * @create 2021-04-06 下午4:01 周二
 */
public class TestExchanger {

    private static Exchanger<String> exchanger = new Exchanger<>();

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.execute(()->{
            try {
                String s = exchanger.exchange("from A : awsl");
                System.out.println("A:"+s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        service.execute(()->{
            try {
                System.out.println("ssssss");
                TimeUnit.SECONDS.sleep(3);
                String s = exchanger.exchange("from b : yyds, too");
                System.out.println("b:"+s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
    }
}
