// # 146 LRU Cache
//Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
//
//get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
//set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
//
//Tags: Data Structure

public class LRUCache { 
    class Node 
    { 
        Node next; 
        Node pre; 
        int key; 
        int val; 
         
        public Node(int key, int val) 
        { 
            this.val = val; 
            this.key = key; 
        } 
    } 
    private int capacity; 
    private int num; 
    private HashMap<Integer, Node> map; 
    private Node first, last; 
     
    public LRUCache(int capacity) { 
        this.capacity = capacity; 
        num = 0; 
        map = new HashMap<Integer, Node>(); 
        first = null; 
        last = null; 
    } 
     
    public int get(int key) { 
       // if (!map.containsKey(key)) return -1; 
        Node node = map.get(key); 
        if (node == null) return -1; 
        else if (node != last) 
        { 
            if (node == first)  
                first = first.next; 
            else  
                node.pre.next = node.next; 
            node.next.pre = node.pre; 
            last.next = node; 
            node.pre = last; 
            node.next = null; 
            last = node; 
        } 
        return node.val; 
    } 
     
    public void set(int key, int value) { 
        Node node = map.get(key); 
        if (node != null)  
        {   
            node.val = value; 
            if (node != last) 
            { 
                if (node == first)  
                    first = first.next; 
                else  
                    node.pre.next = node.next; 
                node.next.pre = node.pre; 
                last.next = node; 
                node.pre = last; 
                node.next = null; 
                last = node; 
            } 
        } 
        else 
        { 
            Node newNode = new Node(key, value); 
            if (num >= capacity) 
            { 
                map.remove(first.key); 
                first = first.next; 
                if (first != null) 
                    first.pre = null; 
                else 
                    last = null; 
                num--; 
            } 
            if (first == null || last == null) 
                first = newNode; 
            else 
            { 
                last.next = newNode; 
            } 
            newNode.pre = last; 
            last = newNode; 
            map.put(key, newNode); 
            num++; 
        } 
    } 
}