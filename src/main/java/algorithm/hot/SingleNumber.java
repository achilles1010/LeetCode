package algorithm.hot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problemset/hot-100/
 * @author daixulin
 * @version : v1.0
 * @date 2020-07-02 1:59 下午 周四
 */
public class SingleNumber {

    public static List<Integer> singleNumber(int[] nums) {
       Map<Integer, Integer> map = new HashMap<>();
       for (Integer i : nums) {
           Integer count = map.get(i);
           count = count == null ? 1 : ++count;
           map.put(i, count);
       }

       List<Integer> list = new ArrayList<>();

       for (Integer i : map.keySet()) {
           if (map.get(i) == 1) {
               list.add(i);
           }
       }

        return list;
    }

    public static List<Integer> singleNumberV2(int[] nums) {
        int ans = nums[0];
        List<Integer> list = new ArrayList<>();
        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                ans = ans ^ nums[i];
                list.add(ans);
            }
        }
        return list;
    }

    public static Integer singleNumberV3(int[] nums) {
        int ans = 0;
        for (int i : nums) {
            ans ^= i;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,3,4,2};
        System.out.println(singleNumberV3(nums));
    }
}
