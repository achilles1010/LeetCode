package learn.algorithm;

import learn.algorithm.tree.ListNode;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2020-06-19 11:06 上午 周五
 */
public class CirclePointer {
    public static boolean hasCycle(ListNode head) {
        ListNode fast, slow;
        fast =  slow = head;
        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();

            if (fast == slow) {
                return true;
            }
        }

        return false;
    }

    ListNode detectCycle(ListNode head) {
        ListNode fast, slow;
        fast = slow = head;
        fast = fast.getNext().getNext();
        slow = slow.getNext();

        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            if (fast == slow) {
                break;
            }
        }

        slow = head;
        while (slow != fast) {
            fast = fast.getNext();
            slow = slow.getNext();
        }

        return slow;
    }

    public static void main(String[] args) {
        ListNode s0 = new ListNode(1);
        ListNode s1 = new ListNode(2);
        ListNode s2 = new ListNode(3);
        ListNode s3 = new ListNode(4);
        ListNode s4 = new ListNode(5);
        ListNode s5 = new ListNode(6);

        s0.setNext(s1);
        s1.setNext(s2);
        s2.setNext(s3);
        s3.setNext(s4);
        s4.setNext(s5);
        s5.setNext(s3);

        System.out.println(hasCycle(s0));
    }
}
