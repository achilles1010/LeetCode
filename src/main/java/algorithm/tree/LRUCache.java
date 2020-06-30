package algorithm.tree;

import lombok.Data;

import java.util.HashMap;

/**
 * The type Tree node.
 * @author daixulin
 */
@Data
public class LRUCache {

    static class DoubleList {
        public void addFirst(Node x) {

        }

        public void remove(Node x) {

        }

        public Node removeLast() {
            return null;
        }

        public int size() {
            return 0;
        }
    }

    @Data
    static class Node{
        public int key, val;
        public LRUCache next, prev;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private HashMap<Integer, Node> map;
    private DoubleList cache;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.cache = new DoubleList();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        int val = map.get(key).val;
        put(key, val);
        return val;
    }

    public void put(int key, int val) {
        Node x = new Node(key, val);
        if (map.containsKey(key)) {
            cache.remove(map.get(key));
        } else {
            if (this.capacity == cache.size()) {
                Node last = cache.removeLast();
                map.remove(last.key);
            }
        }
        cache.addFirst(x);
        map.put(key, x);
    }
}
