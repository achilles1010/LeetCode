package algorithm.hot;


import algorithm.tree.TreeNode;

import java.util.Stack;

/**
 * 汉明问题
 *
 * @author daixulin
 * @version : v1.0
 * @date 2020 -07-02 1:59 下午 周四
 */
public class MergeTrees {


    /**
     * Merge trees tree node. 递归
     * 思想：将一棵树t2，合并到另一棵树t1
     * 递归公式：合并当前节点 + 合并左子树 + 合并右子树
     *  终止条件：t1或t1的节点为空
     * @param x the x
     * @param y the y
     * @return the tree node
     */
    public static TreeNode mergeTrees(TreeNode x, TreeNode y) {
        // 1.合并当前节点 x没有 y不变 返回y
        if (x == null) {
            return y;
        }

        // 2.x没有 x不变 返回x
        if (y == null) {
            return  x;
        }

        // x y都有 节点值相加 更新x
        x.setVal(x.getVal() + y.getVal());

        // 递归合并左右子树 前序遍历
        x.setLeft(mergeTrees(x.getLeft(), y.getLeft()));
        x.setRight(mergeTrees(x.getRight(), y.getRight()));;
        return x;
    }

    public static TreeNode mergeTreesV2(TreeNode x, TreeNode y) {
        if (x == null) {
            return y;
        }

        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[]{x, y});
        while (!stack.isEmpty()) {
            TreeNode[] t = stack.pop();
            if (t[0] == null || t[1] == null)  {
                continue;
            }

            t[0].setVal(t[0].getVal() + t[1].getVal());
            if (t[0].getLeft() == null) {
                t[0].setLeft(t[1].getLeft());
            } else {
                stack.push(new TreeNode[] {t[0].getLeft(), t[1].getLeft()});
            }

            if (t[0].getRight() == null) {
                t[0].setRight(t[1].getRight());
            } else {
                stack.push(new TreeNode[] {t[0].getRight(), t[1].getRight()});
            }
        }

        return x;
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
       TreeNode x = new TreeNode(1);
       x.setLeft(new TreeNode(2));
       x.setRight(new TreeNode(2));
       x.getLeft().setLeft(new TreeNode(3));
//        x.getLeft().setRight(new TreeNode(3));
       x.getRight().setLeft(new TreeNode(3));
//        x.getRight().setRight(new TreeNode(3));

        TreeNode y = new TreeNode(5);
        y.setLeft(new TreeNode(6));
        y.setRight(new TreeNode(6));
//        y.getLeft().setLeft(new TreeNode(7));
        y.getLeft().setRight(new TreeNode(7));
//        y.getRight().setLeft(new TreeNode(7));
        y.getRight().setRight(new TreeNode(7));

//        System.out.println(mergeTrees(x,y));
        System.out.println(mergeTreesV2(x,y));
    }
}
