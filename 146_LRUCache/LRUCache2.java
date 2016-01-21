import java.util.HashMap;
public class LRUCache2 { 
    private final int cap; 
    private int N = 0; 
    private Node first, last; 
    private HashMap<Integer, Node> map; 
    
    private class Node { 
        int key;
        int value; 
        Node pre, next; 
        public Node(int k, int v) { 
            this.key = k; 
            this.value = v; 
            pre = null; 
            next = null; 
        } 
    } 
    
    public LRUCache2(int capacity) { 
        this.cap = capacity; 
        first = null; 
        last = null; 
        map = new HashMap<Integer, Node>(); 
    }
    public int get(int key) { 
        if (map.isEmpty() || !map.containsKey(key)) { 
            return -1; 
        } 
        Node node = map.get(key); 
        int val = node.value; 
        if (node == last) { 
            return val; 
        } 
        else if (node == first) { // node != last 
            first = first.next; 
        } 
        else { 
            node.pre.next = node.next; 
        } 
        node.next.pre = node.pre; 
        node.pre = last; 
        last.next = node; 
        node.next = null; 
        last = node; 
        return val; 
    } 
    
    public void set(int key, int value) { 
        if (first == null && last == null) { 
            last = new Node(key, value); 
            first = last; 
            N++; 
            map.put(key, last); 
            return;
        } 
        else if (map.containsKey(key)) { 
            Node node = map.get(key); 
            node.value = value; 
            if (node == last) { 
                return; 
            } 
            else if (node == first) { 
                first = first.next; 
            } 
            else { 
                node.pre.next = node.next; 
            } 
            node.next.pre = node.pre; 
            node.pre = last; 
            last.next = node; 
            node.next = null; 
            last = node;
        } 
        else {
            last.next = new Node(key, value); 
            last.next.pre = last; 
            last = last.next; 
            N++; 
            map.put(key, last); 
        } 
        if (N == cap + 1) { 
            first.next.pre = null; 
            map.remove(first.key);
            Node next = first.next; 
            first.next = null; 
            first = next;
            N--;
        } 
        return; 
    }
    public static void main(String[] args) {
        LRUCache2 lru = new LRUCache2(2);
        lru.set(2, 1);
        lru.set(1, 1);
        System.out.println(lru.get(2));
        lru.set(4, 1);
        System.out.println(lru.get(1));
        System.out.println(lru.get(2));
    }
}