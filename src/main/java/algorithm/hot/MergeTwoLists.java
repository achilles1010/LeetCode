package algorithm.hot;

import algorithm.tree.ListNode;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2020-07-07 11:07 上午 周二
 */
public class MergeTwoLists {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        if (l1.getVal() < l2.getVal()) {
            l1.setNext(mergeTwoLists(l1.getNext(), l2));
            return l1;
        } else {
            l2.setNext(mergeTwoLists(l1, l2.getNext()));
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.setNext(new ListNode(2));
        l1.getNext().setNext(new ListNode(4));

        ListNode l2 = new ListNode(3);
        l2.setNext(new ListNode(5));

        System.out.println(mergeTwoLists(l1, l2));
    }
}
