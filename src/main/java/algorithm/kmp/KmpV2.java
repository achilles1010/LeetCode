package algorithm.kmp;

import java.util.Arrays;

/**
 * @author daixulin
 * @version : v1.0
 * @see github.com/achilles1010/fucking-algorithm/blob/master/%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92%E7%B3%BB%E5%88%97/%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92%E4%B9%8BKMP%E5%AD%97%E7%AC%A6%E5%8C%B9%E9%85%8D%E7%AE%97%E6%B3%95.md
 * @date 2020-05-26 2:58 下午 周二
 */
public class KmpV2 {
    public static void getNext(String pattern, int[] next) {
        int len = pattern.length();
        next[0] = -1;
        int k = -1, j = 0;
        while (j < (len - 1)) {
            System.out.println("**************************");
            System.out.println("now k:"+k+",j:"+j);
            if (k >= 0) {
                System.out.println("now p[k]:"+pattern.charAt(k));
            }

            System.out.println("now p[j]:"+pattern.charAt(j));

            if (k == -1 || pattern.charAt(j) == pattern.charAt(k)) {
                System.out.println("=========================");
                System.out.println("before k:"+k);
                System.out.println("before j:"+j);
                ++k;
                ++j;
                System.out.println("after k:"+k);
                System.out.println("after j:"+j);
                next[j] = k;
                System.out.println("current next[j]:"+Arrays.toString(next));
            } else {
                // 递归查找p[k] = p[j]
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!");
                k = next[k];
                if (k>=0) {
                    System.out.println("inter next[k]:"+next[k]);
                }
                System.out.println("inter k:"+k);
            }
        }
    }

    public static void main(String[] args) {
        String pattern = "ABCDABD";
        int[] next = new int[pattern.length()];
        getNext(pattern, next);
        System.out.println(Arrays.toString(next));
    }
}
