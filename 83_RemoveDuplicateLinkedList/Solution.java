// #83 Remove Duplicates from Sorted List 
// Given a sorted linked list, delete all duplicates such that each element appear only once.
// For example,
// Given 1->1->2, return 1->2.
// Given 1->1->2->3->3, return 1->2->3.
// Linked List

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
    public ListNode deleteDuplicates(ListNode head) { 
         
 
        ListNode current = head; 
        ListNode temp; 
         
        while (current != null && current.next != null) 
        { 
            if (current.val == current.next.val) 
            { 
                temp = current.next.next; 
                current.next.next = null; 
                current.next = temp; 
                 
            } 
            else current = current.next; 
        } 
        temp = null; 
        return head; 
         
    } 
}