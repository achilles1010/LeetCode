package learn.algorithm.hot;

/**
 * https://leetcode-cn.com/problems/find-the-duplicate-number/solution/er-fen-fa-si-lu-ji-dai-ma-python-by-liweiwei1419/
 * @author daixulin
 * @version : v1.0
 * @date 2020-07-02 1:59 下午 周四
 */
public class FindDuplicate {
   public static int findDuplicateV1(int[] nums) {
       int len = nums.length;
       int left = 1;
       int right = len - 1;
       while (left < right) {
           // left + right 溢出的时候，无符号右移保证结果依然正确
           int mid = (left + right) >>> 1;

           int cnt = 0;
           for (int num : nums) {
               if (num <= mid) {
                   cnt += 1;
               }
           }

           // 根据抽屉原理，小于等于 4 的个数如果严格大于 4 个
           // 此时重复元素一定出现在 [1, 4] 区间里
           if (cnt > mid) {
               // 重复元素位于区间 [left, mid]
               right = mid;
           } else {
               // if 分析正确了以后，else 搜索的区间就是 if 的反面
               // [mid + 1, right]
               left = mid + 1;
           }
       }
       return left;
   }

    public static int findDuplicateV2(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        slow = 0;
        while (slow!=fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,3,4,2};
        System.out.println(findDuplicateV2(nums));
    }
}
