package learn.algorithm.tree;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * The type Tree node.
 * @author daixulin
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode
public class ListNode {
    /**
     * The Val.
     */
    private int val;

    /**
     * The next.
     */
    private ListNode next;

    /**
     * Instantiates a new Tree node.
     *
     * @param x the x
     */
    public ListNode(int x) {
        this.val = x;
    }
}
