// #143 Reorder List 
// Given a singly linked list L: L0?L1?É?Ln-1?Ln,
// reorder it to: L0?Ln?L1?Ln-1?L2?Ln-2?É
// You must do this in-place without altering the nodes' values.
// For example,
// Given {1,2,3,4}, reorder it to {1,4,2,3}.


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
    public void reorderList(ListNode head) { 
        
        if (head == null || head.next == null) return; 
         
        ListNode fast = head; 
        ListNode slow = head; 
     
    // Find the middle node     
        while (true) 
        { 
            fast = fast.next; 
            if (fast == null) break; 
            fast = fast.next; 
            if (fast == null) break; 
            slow = slow.next; 
        } 
         
        if (slow == null) return; 
         
     // reverse the list from the middle node 
    ListNode current = slow.next; 
    slow.next = null; 
    current = reverseList(current); 
    
    
    // merge two list 
    
    ListNode p1 = head; 
    ListNode p2 = current; 
     
    while (p2 != null) 
    { 
        ListNode temp1 = p1.next; 
        ListNode temp2 = p2.next; 
         
        p1.next = p2; 
        p2.next = temp1; 
         
        p1 = temp1; 
        p2 = temp2; 
    } 
         
    } 
     
    private ListNode reverseList(ListNode head) 
    { 
    ListNode previous = head; 
    ListNode current = head.next; 
    while (current != null) 
    { 
        ListNode temp = current.next; 
        current.next = previous; 
        previous = current; 
        current = temp; 
    } 
    head.next = null; 
    return previous; 
    } 
}