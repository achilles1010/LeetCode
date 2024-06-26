package learn.alc;

/**
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * 示例 1：
 * 输入：n = 2
 * 输出：1
 * 示例 2：
 * 输入：n = 5
 * 输出：5
 * @link https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof
 * @author daixulin
 * @version : v1.0
 * @date 2021-04-23 下午7:18 周五
 */
public class Fib {
    public static int fun(int n) {
        int a = 0, b = 1, sum;
        for (int i = 0; i < n; i++) {
           sum = (a + b)  % 1000000007 ;
           a = b;
           b = sum;
        }

        return a;
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(fun(n));
    }
}
