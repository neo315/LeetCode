// #21 Merge Two Sorted Lists 
// Merge two sorted linked lists and return it as a new list. 
// The new list should be made by splicing together the nodes of the first two lists.

//  Linked List

// /** 
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) { 
         
        ListNode head = new ListNode(-1); 
        ListNode current = head; 
         
        while (l1 != null && l2 != null) 
        { 
             
            if (l2.val < l1.val) 
            { 
                current.next = l2; 
                l2 = l2.next; 
            } 
            else  
            { 
                current.next = l1; 
                l1 = l1.next; 
            } 
             
            current = current.next; 
        } 
         
        if (l1 == null)  
        { 
                current.next = l2; 
        } 
             
        else 
        { 
                current.next = l1; 
        } 
             
        head = head.next; 
        return head; 
    } 
}