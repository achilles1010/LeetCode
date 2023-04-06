package learn.alc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @description 找出数组中重复的数字。
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * 示例 1：
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 * 限制：
 * 2 <= n <= 100000
 *
 * @link https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 * @author daixulin
 * @version : v1.0
 * @project :LeetCode
 * @create 2021-04-22 上午9:40 周四
 */
public class FindRepeatNumber {

    public static int func(int[] nums) {
        //hash表 利用hashSet不能存放 非重复元素
        Set<Integer> set = new HashSet<>();
        int res = -1;

        for (int num: nums ) {
            // add失败 返回false 找到了重复元素
           if (!set.add(num))  {
               res = num;
               break;
           }
        }

        return res;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static int func1(int[] nums) {
        //1 ~ n-1
        int n = nums.length;
        for (int num : nums) {
            if (num < 0 || num >= n) {
                return -1;
            }
        }

        //利用下标替换 保证下标 == 元素值 则表示重复
        // 可以将值为 i 的元素调整到第 i 个位置上进行求解
        //  (2, 3, 1, 0, 2, 5)  (nums[0] != 0 && nums[nums[0]] != nums[0]) => 2!=0 && 1!=2)
        //  第i个元素不等于下标 以及 第i个元素 和 下标为nums[元素]的值不相等
        for (int i = 0; i < n; i++) {
            while (nums[i] != i) {
                if (nums[nums[i]] == nums[i]) {
                    return nums[i];
                } else {
                    // 交换nums[i], nums[nums[i]] 将下标为i的元素 与 下标为num[i]的元素互换
                    swap(nums, i, nums[i]);
                }

            }
//            while (nums[i] != i && nums[nums[i]] != nums[i]) {
//                // 交换nums[i], nums[nums[i]] 将下标为i的元素 与 下标为num[i]的元素互换
//                swap(nums, i, nums[i]);
//            }
//            if (nums[i] != i && nums[nums[i]] == nums[i]) {
//                return nums[i];
//            }
        }

        return -1;
    }

    /**
     * 原地哈希法，时间O(n),空间O(1),修改原数据。因为所有的元素都小于len(nums),所以可以让位置i放置元素值i，如果位置i的元素值不是i，则可以交换nums[i]与nums[nums[i]],这样nums[i]的值就被正确归位了，
     * 继续交换直到位置[i]也被正确交换了。如果我们发现nums[i]与nums[nums[i]]的值一致，则发现了重复的元素，返回即可。
     * 针对性较强，普适性较弱。时间复杂度的算法：因为每交换一次数组位置，至少有一个元素被放到了该元素值对应的下标的位置，至多2个，所有有n个元素，最坏的考虑就是需要操作n次。所以是O(n)
     * @param nums
     * @return
     */
    public static int fun2(int[] nums) {
        //设索引初始值为 i = 0
        int i = 0;

        while ( i < nums.length) {
            //索引 i 的值为 i,无需执行交换操作，查看下一位
            if (nums[i] == i ) {
                i++;
                continue;
            }

            //索引 nums[i] 处的值也为 nums[i]，即找到一组相同值，返回 nums[i] 即可
            if (nums[nums[i]] == nums[i]) {
                return nums[i];
            } else {
                //执行交换操作，目的是为了使索引与值一一对应，即索引 0 的值为 0，索引 1 的值为 1
                swap(nums, i, nums[i]);
            }
        }

        return -1;
    }

    public static int fun3(int[] nums) {
        //排序比较法，时间O(nlogn),空间O(1)，修改原数据。先排序，然后看相邻元素是否相同，有相同的就返回。
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
           if (nums[i] == nums[i+1]) {
               return nums[i];
           }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {0,2,1,2,3};
//        System.out.println(fun2(nums));
        System.out.println(fun3(nums));
    }
}
