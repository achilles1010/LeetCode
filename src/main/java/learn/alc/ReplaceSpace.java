package learn.alc;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 示例 1：
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * 限制：
 * 0 <= s 的长度 <= 10000
 * @link ://leetcode-cn.com/problems/ti-huan-kong-ge-lcof
 * @author daixulin
 * @version : v1.0
 * @project :LeetCode
 * @create 2021-04-22 下午2:10 周四
 */
public class ReplaceSpace {
    public static String fun(String s) {
        // 时间复杂度：O(n)。遍历字符串 s 一遍。
        // 空间复杂度：O(n)。额外创建字符数组，长度为 s 的长度的 3 倍。
        int len = s.length();
        char[] array = new char[len * 3];
        int size = 0;
        for (int i = 0; i < len; i++) {
           char c = s.charAt(i);
           if (c == ' ') {
               array[size++] = '%';
               array[size++] = '2';
               array[size++] = '0';
           } else {
               array[size++] = c;
           }
        }

        return new String(array, 0, size);
    }



    public static void main(String[] args) {
        String s = "i am offer";
        System.out.println(fun(s));
    }
}
