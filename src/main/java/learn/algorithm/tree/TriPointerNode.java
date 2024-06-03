package learn.algorithm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * The type Tree node.
 * @author daixulin
 */
public class TriPointerNode<T> {
    /**
     * The Val.
     */
    public T val;

    /**
     * The next.
     */
    public TriPointerNode<T> right;

    /**
     * The Pre.
     */
    public TriPointerNode<T> left;

    public TriPointerNode<T> parent;

    /**
     * Instantiates a new Tree node.
     *
     * @param x the x
     */
    public TriPointerNode(T x) {
        this.val = x;
        left = null;
        right = null;
        parent = null;
    }

    public void addLeftChild(TriPointerNode<T> child) {
        if (child != null) {
            child.parent = this;
            this.left = child;
        }
    }

    public void addRightChild(TriPointerNode<T> child) {
        if (child != null) {
            child.parent = this;
            this.right = child;
        }
    }

    public static void preorder(TriPointerNode<Integer> root, List<Integer> res) {
        if (root == null) {
            return;
        }

        preorder(root.left, res);
        preorder(root.right, res);
        res.add(root.val);

    }

    public static List<Integer> preorderTraversal(TriPointerNode<Integer> root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    public static <T> TriPointerNode<T> generateFullBinaryTree(int depth, TriPointerNode<T> parent, AtomicLong value) {
        if (depth == 0) {
            return null;
        }

        T currentValue = (T)(Long) value.getAndIncrement();
        TriPointerNode<T> node = new TriPointerNode<>(currentValue);
        node.parent = parent;
        node.left = generateFullBinaryTree(depth - 1, node, value);
        node.right = generateFullBinaryTree(depth - 1, node, value);

        return node;
    }

    // 辅助方法用于递归打印先序遍历
    private static void printPreorder(TriPointerNode<Long> node, String prefix) {
        if (node == null) {
            return;
        }
        // 打印当前节点（可以打印值或检查是否为null）  
        System.out.println(prefix + "Value: " + (node.val != null ? node.val.toString() : "null") + ", Parent: " + (node.parent != null ? "(exists)" : "null"));
        // 递归打印左子树  
        printPreorder(node.left, prefix + " left ");
        // 递归打印右子树  
        printPreorder(node.right, prefix + " right ");
    }

    public static void main(String[] args) {
        AtomicLong counter = new AtomicLong(1); // 从1开始计数
        TriPointerNode<Long> root = TriPointerNode.generateFullBinaryTree(3, null, counter);
        assert root != null;
        printPreorder(root, "");
    }
}
