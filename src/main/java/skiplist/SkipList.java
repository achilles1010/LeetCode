package skiplist;

import java.util.Random;

/**
 * @author daixulin
 * @version : v1.0
 * @project :LeetCode
 * @create 2021-03-15 上午10:59 周一
 */
public class SkipList<T> {
    private SkipListNode<T> head, tail;
    private int size;
    private int listLevel;
    private Random random;
    public static final double PROBABILITY = 0.5;

    public SkipList() {
        head = new SkipListNode<T>(SkipListNode.HEAD_KEY, null);
        tail = new SkipListNode<>(SkipListNode.TAIL_KEY, null);
        head.next = tail;
        tail.pre = head;
        size = 0;
        listLevel = 0;
        random = new Random();
    }

    public SkipListNode<T> get(int key) {
        return null;
    }
}
