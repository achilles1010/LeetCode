package learn.algorithm.hot;

import learn.algorithm.tree.ListNode;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2020-07-14 2:48 下午 周二
 */
public class GetIntersectionNode {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 定义两个指针, 第一轮让两个到达末尾的节点指向另一个链表的头部, 最后如果相遇则为交点(在第一轮移动中恰好抹除了长度差)
        // 两个指针等于移动了相同的距离, 有交点就返回, 无交点就是各走了两条指针的长度
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        // 在这里第一轮体现在pA和pB第一次到达尾部会移向另一链表的表头, 而第二轮体现在如果pA或pB相交就返回交点, 不相交最后就是null==null
        while ( pA != pB ) {
           pA = pA == null ? headB : pA.getNext();
           pB = pB == null ? headA : pB.getNext();
        }
        return pA;
    }

    public static void main(String[] args) {
        ListNode headA = new ListNode(1);
        headA.setNext(new ListNode(2));
        headA.getNext().setNext(new ListNode(3));

        ListNode headB = new ListNode(13);
        headB.setNext(new ListNode(2));
        headB.getNext().setNext(new ListNode(3));

//        System.out.println(headA);
//        System.out.println(headB);
        System.out.println(getIntersectionNode(headA, headB));
    }
}
