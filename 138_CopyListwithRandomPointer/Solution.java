// # 138 Copy List with Random Pointer 
//A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
//
//Return a deep copy of the list.
//
//Tags: Hash Table, Linked List

/** 
 * Definition for singly-linked list with a random pointer. 
 * class RandomListNode { 
 *     int label; 
 *     RandomListNode next, random; 
 *     RandomListNode(int x) { this.label = x; } 
 * }; 
 */ 
public class Solution { 
    public RandomListNode copyRandomList(RandomListNode head) { 
        if (head == null) return null; 
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>(); 
        RandomListNode newhead = new RandomListNode(0); 
        RandomListNode pre = newhead; 
        RandomListNode cur = newhead.next; 
        RandomListNode oldhead = head; 
        while (head != null) 
        { 
            cur = new RandomListNode(head.label); 
            map.put(head, cur); 
            pre.next = cur; 
            head = head.next; 
            pre = pre.next; 
        } 
         
        cur = newhead.next; 
        while (oldhead != null) 
        { 
            RandomListNode temp = oldhead.random; 
            cur.random = map.get(temp); 
            oldhead = oldhead.next; 
            cur = cur.next; 
        } 
         
        return newhead.next; 
    } 
}