package offer.alc;

/**
 * 二维数组中的查找
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 示例:
 * 现有矩阵 matrix 如下：
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定target=5，返回true。
 * 给定target=20，返回false。
 * 限制：
 * 0 <= n <= 1000
 * 0 <= m <= 1000
 *
 * @link //leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 * @author daixulin
 * @version : v1.0
 * @project :LeetCode
 * @create 2021-04-22 上午10:49 周四
 */
public class FindNumberIn2DArray {
    public static boolean func1(int[][] matrix, int target) {
        //时间复杂度：O(n+m)。访问到的下标的行最多增加 n 次，列最多减少 m 次，因此循环体最多执行 n + m 次。
        //空间复杂度：O(1)
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        } else {
            int rows = matrix.length, columns = matrix[0].length;
            int row = 0, column = columns - 1;
            while (row < rows && column >0) {
               if (matrix[row][column] == target)   {
                   return true;
               } else if (matrix[row][column] > target) {
                   column--;
               } else {
                   row++;
               }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4,}, {4,5,6,7},{8,9,10,11}};
        System.out.println(func1(matrix, 11));
    }
}
