package offer.alc;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如 * 数组[3,4,5,1,2]为[1,2,3,4,5] 的一个旋转，该数组的最小值为1.
 * 示例 1：
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 示例 2：
 * 输入：[2,2,2,0,1]
 * 输出：0
 * @link https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
 * @author daixulin
 * @version : v1.0
 * @project :LeetCode
 * @create 2021-04-28 下午5:04 周三
 */
public class minArray {
    public static int func(int[] arr) {
        int left = 0, right = arr.length - 1;
        if (right == 0){
            return arr[0];
        } else {
            while (left < right) {
                // 二分查找
               int mid = left + (right - left) / 2;
               if (arr[mid] > arr[right]) {
                   left = mid + 1;
               } else if (arr[mid] < arr[right]) {
                   right = mid;
               } else if (arr[mid] == arr[right]){
                   right--;
               }
            }

            return arr[left];
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,3,4,1};
        System.out.println(func(arr));
    }
}
