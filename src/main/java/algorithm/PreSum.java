package algorithm;

import java.util.HashMap;

/**
 * The type Two sum. 和为K的子数组 https://leetcode-cn.com/problems/subarray-sum-equals-k
 *
 * @author daixulin
 * @version : v1.0
 * @date 2020 -06-16 2:40 下午 周二
 */
public class PreSum {

    public static int subarraySumV0(int[] nums, int k) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        preSum[0]  = 0;
        for (int i = 0; i < n; i++) {
            preSum[i+1] = preSum[i] + nums[i];
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (preSum[i] - preSum[j] == k) {
                    ans++;
                }
            }
        }

        return ans;
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        int[] nums = {1,2,1,2};
        System.out.println(subarraySum(nums,3));
    }

    static int subarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0,1);

        int ans = 0;
        int sumI = 0;
        for (int i = 0; i < n; i++) {
            sumI += nums[i];

            // (向后累加值之和-k)出现在曾经的累加值集合中 证明有集合成员相加等于k
            int sumJ = sumI - k;
            if (preSum.containsKey(sumJ)) {
                ans += preSum.get(sumJ);
            }

            preSum.put(sumI, preSum.getOrDefault(sumI, 0) + 1);
        }

        return ans;
    }


}
