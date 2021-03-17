package jmm.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2021-03-17 下午5:06 周三
 */
public class ABAStamp {

    static BuildingBlock A = new BuildingBlock("三角形");
    static AtomicStampedReference<BuildingBlock> atomicStampedReference = new AtomicStampedReference<>(A, 1);

    // 初始化一个积木对象B，形状为四边形
    static BuildingBlock B = new BuildingBlock("四边形");
    // 初始化一个积木对象D，形状为五边形
    static BuildingBlock D = new BuildingBlock("五边形");

    public static void main(String[] args) {

        new Thread(()->{
            try {
                int stamp = atomicStampedReference.getStamp();
                System.out.println(Thread.currentThread().getName() + "\t 第一次版本号" + stamp);
                // 睡眠一秒，保证t1线程，完成了ABA操作
                TimeUnit.SECONDS.sleep(1);

                atomicStampedReference.compareAndSet(A, B, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
                System.out.println(Thread.currentThread().getName() + "\t 第二次版本号" + atomicStampedReference.getStamp()); //乙	 第一次版本号1

                atomicStampedReference.compareAndSet(B, A, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
                System.out.println(Thread.currentThread().getName() + "\t 第三次版本号" + atomicStampedReference.getStamp()); // 乙	 第三次版本号3
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"乙").start();

        new Thread(()->{
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + "\t 第一次版本号" + stamp); // 甲   第一次版本号1
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            boolean r1 = atomicStampedReference.compareAndSet(A, D, stamp, stamp + 1);
            System.out.println(Thread.currentThread().getName() + "\t 修改成功否" + r1 + "\t 当前最新实际版本号：" + atomicStampedReference.getStamp()); // 甲     修改成功否false     当前最新实际版本号：3
            System.out.println(Thread.currentThread().getName() + "\t 当前实际最新值：" + atomicStampedReference.getReference()); // 甲     当前实际最新值：BuildingBlock{shape='三角形}
        }, "甲").start();

    }

    static class BuildingBlock {
        String shape;
        public BuildingBlock(String shape) {
            this.shape = shape;
        }
        @Override
        public String toString() {
            return "BuildingBlock{" + "shape='" + shape + '}';
        }
    }


}
