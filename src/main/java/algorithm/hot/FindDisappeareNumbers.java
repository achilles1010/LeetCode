package algorithm.hot;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2020-07-10 10:28 上午 周五
 */
class FindDisappearedNumbers {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
       HashMap<Integer, Boolean>  map = new HashMap<>();

        for (int num : nums) {
            map.put(num, true);
        }

       List<Integer> ret = new LinkedList<>();

       for (int i = 1; i < nums.length; i++) {
           if (!map.containsKey(i)) {
               ret.add(i);
           }
       }

       return ret;
    }

    public static List<Integer> findDisappearedNumbersV2(int[] nums) {
        //这道题巧妙之处在于(nums[i]-1)的值一定可以作为nums的索引，而比较骚操作的是我们把这个索引对于的数值，即nums[nums[i]-1]变为负数。
        // 注意nums[i]可能在之前的操作中已经成为负数了，所以是将nums[abs(nums[i])-1]变为负数。如果说数组中存在消失的数flag，
        // 那么nums[abs(flag)-1]一定不能变成负数（实际上是nums[flag-1]不会为负数，因为flag一定为正）。
        // 所以找到数组中不为负的数组下标index，这个index=flag-1。然后可以求出flag=index+1;
        for (int i = 0; i < nums.length; i++) {
            //这道题里面其实包含了隐藏的条件，1 ≤ a[i] ≤ n，即每个数字本身都对应一个i-1的数组下标。
            //我们可以利用数组内容本身跟数字下标的关联找出缺失的数字。
            //扫描两遍数组，第一次将所有数字做标记，第二次根据标记信息找出缺失的数字
            int newIdx = Math.abs(nums[i]) -  1;
            if (nums[newIdx] > 0) {
                nums[newIdx] *= -1;
            }
        }

        List<Integer> ret = new LinkedList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] > 0) {
                ret.add(i);
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbersV2(nums));
    }
}
