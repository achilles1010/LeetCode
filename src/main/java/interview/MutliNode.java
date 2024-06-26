package interview;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Random;

/**
 * @description:
 * @author: daixulin
 * @date:  2024-06-03 16:14
 * @version V1.0
 */
public class MutliNode<T> {

    private T val;

    private MutliNode<T> left;

    private MutliNode<T> right;

    private MutliNode<T> up;

    private MutliNode<T> down;

    public MutliNode(T val, MutliNode<T> left, MutliNode<T> right, MutliNode<T> up, MutliNode<T> down) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.up = up;
        this.down = down;
    }

    public MutliNode(T val) {
        this.val = val;
    }

    public MutliNode() {
    }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public MutliNode<T> getLeft() {
        return left;
    }

    public void setLeft(MutliNode<T> left) {
        this.left = left;
    }

    public MutliNode<T> getRight() {
        return right;
    }

    public void setRight(MutliNode<T> right) {
        this.right = right;
    }

    public MutliNode<T> getUp() {
        return up;
    }

    public void setUp(MutliNode<T> up) {
        this.up = up;
    }

    public MutliNode<T> getDown() {
        return down;
    }

    public void setDown(MutliNode<T> down) {
        this.down = down;
    }

    public static MutliNode<Integer> generatorArr(int n) {
        if (n <= 0) {
            return null;
        }

        // 创建第一个节点
        MutliNode<Integer> head = new MutliNode<>();
        head.val = 1;
        // 创建第一维链表
        MutliNode<Integer> current = head;
        for (int i = 2; i <= n; i++) {
            MutliNode<Integer> newNode = new MutliNode<>();
            newNode.setVal(i);
            current.setRight(newNode);
            newNode.setLeft(current);
            current = newNode;
        }
        // 创建剩余维度的链表
        MutliNode<Integer> prevRowHead = head;
        MutliNode<Integer> prevRowCurrent = prevRowHead;
        for (int row = 2; row <= n; row++) {
            MutliNode<Integer> newRowHead = new MutliNode<>();
            newRowHead.setVal(n*(row-1) + 1);
            prevRowCurrent.setDown(newRowHead);
            newRowHead.setUp(prevRowCurrent);
            current = newRowHead;
            for (int col = 2; col <= n; col++) {
                MutliNode<Integer> newNode = new MutliNode<>();
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
        MutliNode node = generatorArr(4);
        printListwNode(node);
    }

    private static void printListwNode(MutliNode node) {
        MutliNode row = node;
        while (row != null) {
            MutliNode cur = row;
            while (cur != null) {
                MutliNode down = cur.getDown();
                System.out.print(cur.val + " " + "up node:" + (cur.up == null ? null : cur.up.val) + "   ");
                cur = cur.right;
            }
            System.out.println();
            row = row.down;
        }

    }
}
