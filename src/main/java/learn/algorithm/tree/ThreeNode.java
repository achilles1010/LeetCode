package learn.algorithm.tree;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Tree node.
 * @author daixulin
 */
public class ThreeNode<T> {
    /**
     * The Val.
     */
    public T val;

    /**
     * The next.
     */
    public ThreeNode<T> right;

    /**
     * The Pre.
     */
    public ThreeNode<T> left;

    public ThreeNode<T> parent;

    /**
     * Instantiates a new Tree node.
     *
     * @param x the x
     */
    public ThreeNode(T x) {
        this.val = x;
        left = null;
        right = null;
        parent = null;
    }

    public void addLeftChild(ThreeNode<T> child) {
        if (child != null) {
            child.parent = this;
            this.left = child;
        }
    }

    public void addRightChild(ThreeNode<T> child) {
        if (child != null) {
            child.parent = this;
            this.right = child;
        }
    }

    public static void main(String[] args) {
        ThreeNode<Integer> root = new ThreeNode<>(1);

        ThreeNode<Integer> left = new ThreeNode<>(2);
        ThreeNode<Integer> right = new ThreeNode<>(3);


        root.addLeftChild(left);
        root.addRightChild(right);

        ThreeNode<Integer> leftGrandson = new ThreeNode<>(4);
        left.addLeftChild(leftGrandson);



        List<Integer> res = preorderTraversal(root);
        System.out.println(res);

        System.out.println("Root: " + root.val);
        if (root.left != null) {
            System.out.println("Left child of root: " + root.left.val);
            if (root.left.left != null) {
                System.out.println("Left child of left child: " + root.left.left.val);
                // 由于有父节点引用，可以回溯
                System.out.println("Parent of left grandchild: " + root.left.left.parent.val);
            }
        }
    }

    public static void preorder(ThreeNode<Integer> root, List<Integer> res) {
        if (root == null) {
            return;
        }

        preorder(root.left, res);
        preorder(root.right, res);
        res.add(root.val);

    }

    public static List<Integer> preorderTraversal(ThreeNode<Integer> root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }
}
