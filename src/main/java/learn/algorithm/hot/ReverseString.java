package learn.algorithm.hot;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2020-07-07 2:23 下午 周二
 */
public class ReverseString {
    public static void helper(char[] s, int left, int right) {
        if (left >= right) {
            return;
        }

        char tmp = s[left];
        s[left++] = s[right];
        s[right--] = tmp;
        helper(s, left, right);
    }

    public static void reverseString(char[] s) {
        helper(s, 0, s.length-1);
    }

    public static void reverseStringV2(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char tmp = s[left];
            s[left++] = s[right];
            s[right--] = tmp;
        }
    }

    public static void main(String[] args) {
        char[] s = {'a', 'b', 'c', 'd'};
        reverseStringV2(s);
        System.out.println(s);
    }
}
