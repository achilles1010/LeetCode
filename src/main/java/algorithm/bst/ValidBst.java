package algorithm.bst;

import algorithm.tree.TreeNode;

/**
 * The type Valid.
 *
 * @author daixulin
 * @version : v1.0
 * @date 2020 -06-16 10:54 上午 周二
 */
public class ValidBst {

    /**
     * Is valid bst boolean.
     *
     * @param treeNode the tree node
     * @return the boolean
     */
    public static boolean isValidBst(TreeNode treeNode) {
        return validate(treeNode, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * Validate boolean.
     *
     * @param treeNode the tree node
     * @param min      the min
     * @param max      the max
     * @return the boolean
     */
    public static boolean validate(TreeNode treeNode, long min, long max) {
        if (treeNode == null) {
            return true;
        }

        if (treeNode.getVal() <= min || treeNode.getVal() >= max) {
            return false;
        }

        System.out.println(treeNode.toString());
        return validate(treeNode.getLeft(), min, treeNode.getVal()) && validate(treeNode.getRight(), treeNode.getVal(), max);
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        TreeNode treeNodeLeft1 = new TreeNode(1);
        TreeNode treeNodeRight1 = new TreeNode(5);
        treeNode.setLeft(treeNodeLeft1);
        treeNode.setRight(treeNodeRight1);
        System.out.println(isValidBst(treeNode));
    }
}
