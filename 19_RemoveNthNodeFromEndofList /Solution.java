// #19 Remove Nth Node From End of List 
//Given a linked list, remove the nth node from the end of list and return its head.
//
//For example,
//
//   Given linked list: 1->2->3->4->5, and n = 2.
//
//   After removing the second node from the end, the linked list becomes 1->2->3->5.
//Note:
//Given n will always be valid.
//Try to do this in one pass.

// Tags: Linked List, Two Pointers

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
    public ListNode removeNthFromEnd(ListNode head, int n) { 
        if (head == null || head.next == null) return null; 
        ListNode fast = head; 
        ListNode slow = head; 
         
        for (int i = 0; i < n; i++) 
            fast = fast.next; 
        if (fast == null)  
        { 
            head = head.next; 
            return head; 
        } 
         
        fast = fast.next; 
        while (fast != null) 
        { 
            fast =fast.next; 
            slow = slow.next; 
        } 
        ListNode temp = slow.next; 
        slow.next = temp.next; 
        temp.next = null; 
        temp = null; 
        return head; 
    } 
}