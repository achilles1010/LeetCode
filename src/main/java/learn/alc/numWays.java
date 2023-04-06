package learn.alc;

/**
 * @author daixulin
 * @version : v1.0
 * @project :LeetCode
 * @create 2021-04-28 下午4:03 周三
 */
public class numWays {
    public static int func(int n) {
        int a = 1, b = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }

        return  a;
    }

    public static void main(String[] args) {
        System.out.println(func(3));
    }
}
