package learn.algorithm;

import learn.algorithm.tree.TreeNode;

/**
 * The type Two sum.
 *
 * @author daixulin
 * @version : v1.0
 * @date 2020 -06-16 2:40 下午 周二
 */
public class PathSum {

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

        System.out.println("**************");
        Sum(root, sum);
        pathSumFun(root.getLeft(), sum);
        pathSumFun(root.getRight(), sum);
        return pathNumber;
    }

    /**
     * Sum.
     *
     * @param root the root
     * @param sum  the sum
     */
    public void Sum(TreeNode root, int sum) {
        System.out.println("==============");
        if (root == null) {
            return;
        }

        sum -= root.getVal();

        if (sum == 0) {
            this.pathNumber++;
        }

        System.out.println(root.toString());
        Sum(root.getLeft(), sum);
        Sum(root.getRight(), sum);
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        TreeNode treeNodeLeft1 = new TreeNode(1);
        TreeNode treeNodeRight1 = new TreeNode(2);
        TreeNode treeNodeLeft2 = new TreeNode(2);
        TreeNode treeNodeRight2 = new TreeNode(6);
        treeNode.setLeft(treeNodeLeft1);
        treeNode.setRight(treeNodeRight1);
        treeNodeLeft1.setLeft(treeNodeLeft2);
        treeNodeRight1.setRight(treeNodeRight2);

        PathSum pathSum = new PathSum();
        System.out.println(pathSum.pathSumFun(treeNode, 8));
    }
}
