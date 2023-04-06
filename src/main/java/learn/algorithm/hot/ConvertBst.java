package learn.algorithm.hot;

import learn.algorithm.tree.TreeNode;
import lombok.Data;

import java.util.Stack;

/**
 * The type Convert bst.
 *
 * @author daixulin
 * @version : v1.0
 * @date 2020 -07-07 2:51 下午 周二
 */
@Data
public class ConvertBst {
    /**
     * Dfs int.
     * 退出条件：当前遍历到的节点为空，返回sum值
     * 过程是逆中序深度优先遍历:
     * 带着sum去遍历右子树，返回遍历后累加得到的sum
     * 将当前节点node.val和sum累加，使node.val符合题目要求
     * 将node.val作为sum值带着去遍历左子树
     *
     * @param root the root
     * @param sum  the sum
     * @return the int
     */
    public int dfs(TreeNode root, int sum) {
        if ( root == null ) {
            return sum;
        }

        sum = dfs(root.getRight(), sum);
        root.setVal(root.getVal() + sum);
        sum = dfs(root.getLeft(), root.getVal());

        return sum;
    }

    /**
     * Convert bst tree node.
     *
     * @param root the root
     * @return the tree node
     */
    public TreeNode convertBst(TreeNode root) {
        if (root != null) {
            dfs(root, 0);
        }

        return root;
    }

    public TreeNode convertBstV2(TreeNode root) {
        int sum = 0;
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || node != null) {
           while (node != null) {
               stack.add(node);
               node = node.getRight();
           }

           node = stack.pop();
           sum += node.getVal();
           node.setVal(sum);

           node  = node.getLeft();
        }

        return root;
    }

    private TreeNode getSuccessor(TreeNode node) {
        TreeNode succ = node.getRight();
        while (succ.getLeft() != null && succ.getLeft() !=node) {
            succ = succ.getLeft();
        }
        return succ;
    }

    public TreeNode convertBstV3(TreeNode root) {
        int sum = 0;
        TreeNode node = root;
        while (node != null) {
            if (node.getRight() == null) {
                sum += node.getVal();
                node.setVal(sum);
                node = node.getLeft();
            } else {
               TreeNode success = this.getSuccessor(node);
               if (success.getLeft() == null) {
                   success.setLeft(node);
                   node = node.getRight();
               } else {
                   success.setLeft(null);
                   sum += node.getVal();
                   node.setVal(sum);
                   node = node.getLeft();
               }
            }
        }

        return root;
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.setLeft(new TreeNode(2));
        root.setRight(new TreeNode(13));

        ConvertBst cb = new ConvertBst();
        TreeNode treeNode = cb.convertBst(root);

        System.out.println(treeNode);
    }
}
