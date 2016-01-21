// #142 Linked List Cycle II 
// Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
// Follow up: Can you solve it without using extra space?
//  Two Pointers

/** 
 * Definition for singly-linked list. 
 * class ListNode { 
 *     int val; 
 *     ListNode next; 
 *     ListNode(int x) { 
 *         val = x; 
 *         next = null; 
 *     } 
 * } 
 */ 
public class Solution { 
    public ListNode detectCycle(ListNode head) { 
 
        ListNode fast = head; 
        ListNode slow = head; 
         
        while (slow != null && fast != null) 
        { 
            fast = fast.next; 
            slow = slow.next; 
            if (fast != null) fast = fast.next; 
            if (fast == slow) break; 
        } 
        if (fast == null) return null; 
         
        slow = head; 
        int count = 0; 
         
        while (fast != slow) 
        { 
            fast = fast.next; 
            slow = slow.next; 
            count++; 
        } 
         
        return slow; 
         
    } 
}