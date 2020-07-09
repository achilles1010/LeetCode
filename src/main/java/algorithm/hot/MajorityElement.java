package algorithm.hot;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * The type Majority element.
 *
 * @author daixulin
 * @version : v1.0
 * @date 2020 -07-07 10:46 上午 周二
 */
public class MajorityElement {
    /**
     * Majority element int.
     *
     * @param nums the nums
     * @return the int
     */
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (Integer num : nums) {
            Integer count = map.get(num);
            count = count == null ? 1 : ++count;
            map.put(num, count);
        }

        int limit = nums.length >> 1;
        for (Integer num : map.keySet()) {
            if (map.get(num) > nums.length/2) {
                return num;
            }
        }

        return -1;
    }

    /**
     * Majority element v 2 int.
     *
     * @param nums the nums
     * @return the int
     */
    public static int majorityElementV2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length >> 1];
    }

    /**
     * Majority element v 3 int.
     * 摩尔投票法思路
     * 候选人(cardNum)初始化为nums[0]，票数count初始化为1。
     * 当遇到与cardNum相同的数，则票数count = count + 1，否则票数count = count - 1。
     * 当票数count为0时，更换候选人，并将票数count重置为1。
     * 遍历完数组后，cardNum即为最终答案。
     *
     * 为何这行得通呢？
     * 投票法是遇到相同的则票数 + 1，遇到不同的则票数 - 1。
     * 且“多数元素”的个数> ⌊ n/2 ⌋，其余元素的个数总和<= ⌊ n/2 ⌋。
     * 因此“多数元素”的个数 - 其余元素的个数总和 的结果 肯定 >= 1。
     * 这就相当于每个“多数元素”和其他元素 两两相互抵消，抵消到最后肯定还剩余至少1个“多数元素”。
     *
     * https://leetcode-cn.com/problems/majority-element/solution/3chong-fang-fa-by-gfu-2/
     * @param nums the nums
     * @return the int
     */
    public static int majorityElementV3(int[] nums) {
        int cardNum = nums[0], count =1;
        for (int i = 1; i < nums.length; ++i) {
            if (cardNum == nums[i]) {
                ++count;
            } else if (--count == 0) {
                cardNum = nums[i];
                count =1;
            }
        }

        return cardNum;
    }


    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        int[] nums2 = {3,2,3};
        System.out.println(majorityElementV3(nums));
    }
}
