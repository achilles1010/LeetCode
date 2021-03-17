package jmm.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2021-03-17 下午4:58 周三
 */
public class Cas {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(10);
        Boolean r1 = atomicInteger.compareAndSet(10,20);
        System.out.printf("当前atomicInteger变量的值:%d 比较结果%s\r\n", atomicInteger.get(), r1);

        Boolean r2 = atomicInteger.compareAndSet(10,30);
        System.out.printf("当前atomicInteger变量的值:%d 比较结果%s\r\n", atomicInteger.get(), r2);
    }
}
