package jmm.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2021-03-17 下午5:06 周三
 */
public class ABA {

    static BuildingBlock A = new BuildingBlock("三角形");
    static AtomicReference<BuildingBlock> atomicReference = new AtomicReference<>(A);
    static AtomicStampedReference<BuildingBlock> atomicStampedReference = new AtomicStampedReference<>(A, 1);

    // 初始化一个积木对象B，形状为四边形
    static BuildingBlock B = new BuildingBlock("四边形");
    // 初始化一个积木对象D，形状为五边形
    static BuildingBlock D = new BuildingBlock("五边形");

    public static void main(String[] args) {

        new Thread(()->{
//            atomicReference.compareAndSet(A, B);
//            atomicReference.compareAndSet(B, A);
        },"乙").start();

        new Thread(()->{
            try {
                // 睡眠一秒，保证t1线程，完成了ABA操作
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 可以替换成功，因为乙线程执行了A->B->A，形状没变，所以甲可以进行替换。
            System.out.println(atomicReference.compareAndSet(A, D) + "\t" + atomicReference.get()); // true	BuildingBlock{shape='五边形}
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
