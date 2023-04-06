package learn.algorithm;

import learn.algorithm.tree.TreeNode;

/**
 * The type Two sum.
 *
 * @author daixulin
 * @version : v1.0
 * @date 2020 -06-16 2:40 下午 周二
 */
public class PathSumV2 {

    private int pathNumber;

    /**
     * Path sum fun int.
     *
     * @param root the root
     * @param sum  the sum
     * @return the int
     */
    public int pathSumFun(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        int pathImLeading = count(root, sum);
        int leftPathSum = pathSumFun(root.getLeft(), sum);
        int rightPathSum = pathSumFun(root.getRight(), sum);

        return leftPathSum + rightPathSum + pathImLeading;
    }

    /**
     * Sum.
     *
     * @param root the root
     * @param sum  the sum
     */
    public int count(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        int isMe = (root.getVal() == sum) ? 1 : 0;

        int leftBrother = count(root.getLeft(), sum - root.getVal());
        int rightBrother = count(root.getRight(), sum - root.getVal());

        return isMe + leftBrother + rightBrother;
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNodeLeft1 = new TreeNode(3);
        TreeNode treeNodeRight1 = new TreeNode(3);
        TreeNode treeNodeLeft2 = new TreeNode(1);
        TreeNode treeNodeRight2 = new TreeNode(3);
        treeNode.setLeft(treeNodeLeft1);
        treeNode.setRight(treeNodeRight1);
        treeNodeLeft1.setLeft(treeNodeLeft2);
        treeNodeRight1.setRight(treeNodeRight2);

        PathSumV2 pathSum = new PathSumV2();
        System.out.println(pathSum.pathSumFun(treeNode, 4));
    }
}
