package skiplist;

/**
 * @author daixulin
 * @version : v1.0
 * @project :LeetCode
 * @create 2021-03-15 上午10:43 周一
 */
public class SkipListNode<T> {

    public int key;
    public T value;
    public SkipListNode<T> pre, next, up, down;

    public static final int HEAD_KEY = Integer.MIN_VALUE;
    public static final int TAIL_KEY = Integer.MAX_VALUE;

    public SkipListNode(int k, T v) {
        this.key = k;
        this.value = v;
    }

    public int getKey() {
        return key;
    }

    public T getValue() {
        return value;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null) {
            return false;
        }

        if (!(o instanceof SkipListNode)) {
            return false;
        }

        SkipListNode<T> ent;
        try {
            ent = (SkipListNode<T>) o;
        } catch (ClassCastException ex) {
            return false;
        }

        return (ent.getKey() == key) && (ent.getValue() == value);
    }

    @Override
    public String toString() {
        return "key-value:" + key + "," + value;
    }

    private int randomLevel() {
        int level = 1;
        return 0;
    }
}
