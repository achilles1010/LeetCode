package learn.algorithm.tree;

import lombok.Data;

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
}
