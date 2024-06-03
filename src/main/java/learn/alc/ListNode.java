package learn.alc;

import lombok.Data;

import java.sql.SQLOutput;

/**
 * @author daixulin
 * @version : v1.0
 * @project :LeetCode
 * @create 2021-04-22 下午2:40 周四
 */
@Data
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next = new ListNode(6);
        listNode.next.next.next.next.next.next= new ListNode(7);

//        ListNode reverseList = listNode.reverseList(listNode);
//        System.out.println(reverseList);
        System.out.println(listNode);

        ListNode listNode1 = new ListNode(7);

        listNode1.next = new ListNode(8);
        listNode1.next.next = new ListNode(9);
        listNode1.next.next.next = new ListNode(10);

        ListNode mergeTwoLists = listNode.mergeTwoLists(listNode, listNode1);
        System.out.println(mergeTwoLists);
    }


    public ListNode reverseList(ListNode head) {
        ListNode current = head, prev = null;
        while( current != null ) {
            // 1.保存下一个节点
            ListNode next = current.next;
            // 2.反转当前节点指针
            current.next = prev;
            // 3.移动prev到当前节点
            prev = current;
            // 4.移动到下一个节点
            current = next;
        }
        return prev;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }

            current = current.next;
        }

        if (l1 != null) {
            current.next = l1;
        }

        if (l2 != null) {
            current.next = l2;
        }

        return dummy.next;
    }
}
