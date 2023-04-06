package learn.jmm.volatiled;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2021-03-17 下午4:03 周三
 */
public class VolatileResort {
    static int num = 0;

    /**
     * static volatile boolean flag = false;
     * StoreStore内存屏障可以保证在volatile写（flag赋值操作flag=true）之前，
     * 其前面的所有普通写（num的赋值操作num=1) 操作已经对任意处理器可见了，保障所有普通写在volatile写之前刷新到主内存。
     */
    static boolean flag = false;

    public static void init() {
        num = 1;
        flag = true;
    }

    public static void add() {
        if (flag) {
            num = num + 5;
            System.out.println("num:" + num);
        }
    }

    public static void main(String[] args) {
        init();

        //线程1中指令重排： num= 1;flag = true; 的执行顺序变为 flag=true;num = 1;
        //如果线程2 num=num+5 在线程1设置num=1之前执行，那么线程2的num变量值为5。
        new Thread(()-> add(),"子线程").start();
    }
}
