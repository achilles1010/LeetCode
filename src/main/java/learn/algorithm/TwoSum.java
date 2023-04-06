package learn.algorithm;

import java.util.*;

/**
 * The type Two sum.
 *
 * @author daixulin
 * @version : v1.0
 * @date 2020 -06-16 2:40 下午 周二
 */
public class TwoSum {

    /**
     * The Freq.
     */
// method v1
    Map<Integer, Integer> freq = new HashMap<>();

    /**
     * Add.
     *
     * @param number the number
     */
    public void add(int number){
       freq.put(number, freq.getOrDefault(number, 0) + 1);
    }

    /**
     * Find boolean.
     *
     * @param value the value
     * @return the boolean
     */
    public boolean find(int value) {
        for (Integer key : freq.keySet()) {
            int other = value - key;

            // 1
            if (other == key && freq.get(key) > 1) {
                return true;
            }

            if (other != key && freq.containsKey(other)) {
               return true;
            }
        }

        return false;
    }

    /**
     * The Sum.
     */
// method v2
    Set<Integer> sum = new HashSet<>();
    /**
     * The Nums.
     */
    List<Integer> nums = new ArrayList<>();

    /**
     * Add v 2.
     *
     * @param number the number
     */
    public void addV2(int number) {
       for ( int n : nums)  {
           sum.add(n + number);
       }
       nums.add(number);
    }

    /**
     * Find v 2 boolean.
     *
     * @param value the value
     * @return the boolean
     */
    public boolean findV2 (int value) {
        return sum.contains(value);
    }

    /**
     * Tow sum fun int [ ] 无序.
     *
     * @param nums   the nums
     * @param target the target
     * @return the int [ ]
     */
    static int[] towSumFun(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> index = new HashMap<>();

        for (int i = 0; i < n; i++) {
            index.put(nums[i], i);
        }

        for (int i = 0; i < n; i++) {
            // 差值成员
            int other = target - nums[i];

            // 如果包含 取出其下标 且下标不是自己
            if (index.containsKey(other) && index.get(other) != i) {
                return new int[] {i, index.get(other)};
            }
        }

        return new int[]{-1, 1};
    }

    /**
     * Two sum fun v 2 int [ ].
     *
     * @param nums   the nums
     * @param target the target
     * @return the int [ ]
     */
    int[] twoSumFunV2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[] {left, right};
            } else if (sum < target) {
                left++;
            } else {
                right --;
            }
        }
        return new int[]{-1, -1};
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        int[] nums = {1,1,2,3,4,5,6,7,8};
        System.out.println(Arrays.toString(towSumFun(nums, 7)));
    }
}
