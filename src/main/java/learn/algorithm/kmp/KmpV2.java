package learn.algorithm.kmp;

import java.util.Arrays;

/**
 * blog.csdn.net/v_july_v/article/details/7041827
 * @author daixulin
 * @version : v1.0
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

            //①如果k = -1，或者当前字符匹配成功（即P[k] == P[j]），都令k++，j++
            if (k == -1 || pattern.charAt(j) == pattern.charAt(k)) {

                System.out.println("=========================");
                System.out.println("before k:"+k);
                System.out.println("before j:"+j);
                ++k;
                ++j;
                System.out.println("after k:"+k);
                System.out.println("after j:"+j);

                //匹配相同前后缀 有长度k+1 的相同前缀后缀。
                if (pattern.charAt(j+1) == pattern.charAt(k+1)) {
                    ++k;
                    ++j;
                    // 如果p[j + 1] == p[k + 1]，回退后仍然失配，所以要继续回退
                    next[j] = next[k];
                } else {
                    ++k;
                    ++j;
                    // 下一个字符的最大前后缀为k+1;
                    next[j] = k;
                }
                System.out.println("current next:"+Arrays.toString(next));
            } else {
                //②如果j != -1，且当前字符匹配失败（即p[k] != p[j]），则令 j 不变，k = next[k]
                //next[k]即为k所对应的next值 递归查找p[k] = p[j]
                // 寻找 且满足p0 pk'-1 pk' = pj-k' pj-1 pj p[next[k]] 去跟pj 继续匹配
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!");
                System.out.println("inter before k:"+k);
                System.out.println("inter next:"+next[k]);
                // p[k] 与 p[j] 失配时， k至少要移动到next[k] 处才能使得 k 与主字符串的 j 继续匹配
                k = next[k];
                System.out.println("inter after k:"+k);
            }
        }
    }

    public static void main(String[] args) {
        String pattern = "DABCDABDE";
        int[] next = new int[pattern.length()];
        getNext(pattern, next);
        System.out.println(Arrays.toString(next));
    }
}
