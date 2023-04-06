package learn.alc;

/**
 * @author daixulin
 * @version : v1.0
 * @project :LeetCode
 * @create 2021-04-22 下午2:40 周四
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    @Override
    public String toString() {
        if (left == null && right == null) {
            return String.format("[ %d ]", val);
        }
        return String.format("[ %d : %s, %s]", val, left, right);
    }
}
