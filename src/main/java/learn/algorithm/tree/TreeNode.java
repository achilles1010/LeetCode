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

//    public static void main(String[] args) {
//        Integer[] nodes = {1, null, 2, 3};
//        TreeNode root = arrayToBST(nodes);
//        System.out.println(root);
//
//        assert root != null;
//        System.out.println(root.preorderTraversal(root));
//        System.out.println(maxDepth(root));
//        System.out.println(minDepth(root));
//    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 1;
        } else if (root.left == null) {
            return minDepth(root.right) + 1;
        } else if (root.right == null) {
            return minDepth(root.left) + 1;
        } else {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
    }


    public static void main(String[] args) {
        // 构建4个4层的满二叉树
        TreeNode r1 = buildFullBinaryTree(4);
        TreeNode r2 = buildFullBinaryTree(4);
        TreeNode r3 = buildFullBinaryTree(4);
        TreeNode r4 = buildFullBinaryTree(4);

        // 将4棵树的根节点串起来
        r1.right = r2;
        r2.right = r3;
        r3.right = r4;

        // 从任意子节点开始遍历
        TreeNode startNode = r1.left; // 假设从R1的左子节点开始
        printAllTrees(startNode);
    }

    // 构建一个4层的满二叉树
    public static TreeNode buildFullBinaryTree(int levels) {
        if (levels == 0) {
            return null;
        }
        TreeNode root = new TreeNode(1);
        for (int i = 1; i < levels; i++) {
            TreeNode current = root;
            for (int j = 0; j < (1 << i) - 1; j++) {
                current.left = new TreeNode(2 * current.val);
                current.right = new TreeNode(2 * current.val + 1);
                current = current.left; // 这里只遍历左子树，因为满二叉树的特性
            }
        }
        System.out.println(root);
        return root;
    }

    // 从给定的子节点开始遍历四棵树
    public static void printAllTrees(TreeNode start) {
        TreeNode current = start;
        while (true) {
            // 打印当前节点
            System.out.println(current.val);

            // 如果有左子节点，先遍历左子节点
            if (current.left != null) {
                current = current.left;
            } else if (current.right != null) {
                // 如果没有左子节点，遍历右子节点
                current = current.right;
            } else {
                // 如果左右子节点都没有，尝试回退
                while (current.right == null) {
                    current = goUp(current); // 回退到父节点
                    if (current == null) {
                        return; // 如果没有父节点，结束遍历
                    }
                }
                current = current.right; // 回退后，继续遍历右子树
            }
        }
    }

    // 回退到父节点
    public static TreeNode goUp(TreeNode node) {
        if (node.right != null) {
            return node.right; // 如果有右子树，父节点在右子树的末端
        }
        TreeNode parent = node;
        while (parent != null && parent.right != parent) {
            parent = parent.right; // 遍历串联的树
        }
        return parent; // 返回找到的父节点
    }
}
