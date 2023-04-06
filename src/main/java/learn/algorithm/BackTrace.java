package learn.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2020-06-29 10:55 上午 周一
 */
public class BackTrace {
    public List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> listV2 = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0) {
            return null;
        }

        LinkedList<Integer> trace = new LinkedList<>();
        backTrace(nums, trace);
        return list;
    }

    public void backTrace(int[] nums, LinkedList<Integer> trace) {
        if (trace.size() == nums.length) {
            list.add(new LinkedList<>(trace));
            return;
        }

        for (int num : nums) {
            if (trace.contains(num)) {
                continue;
            }
            trace.add(num);
            backTrace(nums, trace);
            trace.removeLast();
        }
    }

    public List<List<Integer>> subsetsV2(int[] nums) {
        if(nums.length == 0){
            return null;
        }
        List<Integer> temp = new ArrayList<>();
        backTraceV2(0, nums, temp);
        return listV2;
    }

    public void backTraceV2(int start, int[] nums, List<Integer> temp){
        //每次都保存结果
        listV2.add(new ArrayList<>(temp));
        //从start开始遍历，避免重复
        for(int j = start; j < nums.length; j++){
            temp.add(nums[j]);
            backTraceV2(j+1,nums,temp);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2};
        BackTrace backTrace = new BackTrace();
        System.out.println(backTrace.subsets(nums));
//        System.out.println(backTrace.subsetsV2(nums));
    }
}
