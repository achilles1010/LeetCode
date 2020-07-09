package algorithm.hot;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problemset/hot-100/
 *
 * @author daixulin
 * @version : v1.0
 * @date 2020 -07-02 1:59 下午 周四
 */
public class SingleNumber {

    /**
     * Single number int.
     *
     * @param nums the nums
     * @return the int
     */
    public static int singleNumber(int[] nums) {
       Map<Integer, Integer> map = new HashMap<>();
       for (Integer i : nums) {
           Integer count = map.get(i);
           count = count == null ? 1 : ++count;
           map.put(i, count);
       }

       for (Integer i : map.keySet()) {
           if (map.get(i) == 1) {
               return i;
           }
       }

        return -1;
    }

    /**
     * Single number v 3 integer. 异或有交换律定理，相当于将相同的数字先异或，这样两两异或就只剩0了，然后0再和最后的一个数字异或得到最终值
     * 交换律：a ^ b ^ c <=> a ^ c ^ b
     * 任何数于0异或为任何数 0 ^ n => n
     * 相同的数异或为0: n ^ n => 0
     * @param nums the nums
     * @return the integer
     */
    public static Integer singleNumberV3(int[] nums) {
        int ans = 0;
        for (int i : nums) {
            ans ^= i;
        }
        return ans;
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        int[] nums = {3,1,3,4,4};
        System.out.println(singleNumberV3(nums));
    }
}
