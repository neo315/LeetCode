// 24 Swap Nodes in Pairs
// Given a linked list, swap every two adjacent nodes and return its head.
// For example,
// Given 1->2->3->4, you should return the list as 2->1->4->3.
// Your algorithm should use only constant space. 
// You may not modify the values in the list, only nodes itself can be changed.

// Linked List

/** 
 * Definition for singly-linked list. 
 * public class ListNode { 
 *     int val; 
 *     ListNode next; 
 *     ListNode(int x) { 
 *         val = x; 
 *         next = null; 
 *     } 
 * } 
 */ 
public class Solution { 
    public ListNode swapPairs(ListNode head) { 
         
        if (head == null) return head; 
        if (head.next == null) return head; 
 
        ListNode first = head; 
        ListNode second = head; 
 
        head = head.next; 
         
        while (second != null && second.next != null) 
        { 
            second = first.next; 
            first.next = second.next; 
            second.next = first; 
            first = first.next; 
            second = second.next; 
           if (first == null || first.next == null) break; 
           second.next = first.next; 
        } 
        return head; 
    } 
}