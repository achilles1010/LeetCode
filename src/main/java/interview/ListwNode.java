package interview;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Random;

/**
 * @description:
 * @author: daixulin
 * @date:  2024-06-03 16:14
 * @version V1.0
 */
@NoArgsConstructor
public class ListwNode<T> {

    private T val;

    private ListwNode<T> left;

    private ListwNode<T> right;

    private ListwNode<T> up;

    private ListwNode<T> down;

    public ListwNode(T val, ListwNode<T> left, ListwNode<T> right, ListwNode<T> up, ListwNode<T> down) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.up = up;
        this.down = down;
    }

    public ListwNode(T val) {
        this.val = val;
    }

    public ListwNode() {
    }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public ListwNode<T> getLeft() {
        return left;
    }

    public void setLeft(ListwNode<T> left) {
        this.left = left;
    }

    public ListwNode<T> getRight() {
        return right;
    }

    public void setRight(ListwNode<T> right) {
        this.right = right;
    }

    public ListwNode<T> getUp() {
        return up;
    }

    public void setUp(ListwNode<T> up) {
        this.up = up;
    }

    public ListwNode<T> getDown() {
        return down;
    }

    public void setDown(ListwNode<T> down) {
        this.down = down;
    }

    public static ListwNode<Integer> generatorArr(int n) {
        if (n <= 0) {
            return null;
        }

        // 创建第一个节点
        ListwNode<Integer> head = new ListwNode<>();
        head.val = 1;
        // 创建第一维链表
        ListwNode<Integer> current = head;
        for (int i = 2; i <= n; i++) {
            ListwNode<Integer> newNode = new ListwNode<>();
            newNode.setVal(i);
            current.setRight(newNode);
            newNode.setLeft(current);
            current = newNode;
        }
        // 创建剩余维度的链表
        ListwNode<Integer> prevRowHead = head;
        ListwNode<Integer> prevRowCurrent = prevRowHead;
        for (int row = 2; row <= n; row++) {
            ListwNode<Integer> newRowHead = new ListwNode<>();
            newRowHead.setVal(n*(row-1) + 1);
            prevRowCurrent.setDown(newRowHead);
            newRowHead.setUp(prevRowCurrent);
            current = newRowHead;
            for (int col = 2; col <= n; col++) {
                ListwNode<Integer> newNode = new ListwNode<>();
                newNode.setVal((row - 1) * n + col);
                current.setRight(newNode);
                newNode.setLeft(current);
                prevRowCurrent = prevRowCurrent.getRight();
                prevRowCurrent.setDown(newNode);
                newNode.setUp(prevRowCurrent);
                current = newNode;
            }

            prevRowHead = newRowHead;
            prevRowCurrent = prevRowHead;
        }

        return head;
    }

    //for test
    public static void main(String[] args) {
        int n = new Random().nextInt(1) + 10;
        System.err.println(n + "维");
        ListwNode node = generatorArr(4);
        printListwNode(node);
    }

    private static void printListwNode(ListwNode node) {
        ListwNode row = node;
        while (row != null) {
            ListwNode cur = row;
            while (cur != null) {
                ListwNode down = cur.getDown();
                System.out.print(cur.val + " " + "up node:" + (cur.up == null ? null : cur.up.val) + "   ");
                cur = cur.right;
            }
            System.out.println();
            row = row.down;
        }

    }
}
