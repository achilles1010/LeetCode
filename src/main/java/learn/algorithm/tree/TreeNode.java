package learn.algorithm.tree;

import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * The type Tree node.
 * @author daixulin
 */
@Data
public class TreeNode {
    /**
     * The Val.
     */
    private int val;
    /**
     * The Left.
     */
    private TreeNode left;
    /**
     * The Right.
     */
    private TreeNode right;

    /**
     * Instantiates a new Tree node.
     *
     * @param x the x
     */
    public TreeNode(int x) {
        this.val = x;
    }


    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    public static TreeNode arrayToBST(Integer[] nodes) {
        if (nodes.length == 0 || nodes[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(nodes[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (i < nodes.length) {
            TreeNode current = queue.poll();
            if (nodes[i] != null) {
                current.left = new TreeNode(nodes[i]);
                queue.add(current.left);
            }
            i++;

            if (i < nodes.length && nodes[i] != null) {
                current.right = new TreeNode(nodes[i]);
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }


    public void preorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        preorder(root.left, res);
        res.add(root.val);
        preorder(root.right, res);

    }

    public static void main(String[] args) {
        Integer[] nodes = {1, null, 2, 3};
        TreeNode root = arrayToBST(nodes);
        System.out.println(root);

        assert root != null;
        System.out.println(root.preorderTraversal(root));
    }
}
