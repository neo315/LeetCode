// #61 Rotate List
// Given a list, rotate the list to the right by k places, where k is non-negative.
//
//For example:
//Given 1->2->3->4->5->NULL and k = 2,
//return 4->5->1->2->3->NULL. 
// Tags: Linked List Two Pointers

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
    public ListNode rotateRight(ListNode head, int n) { 
        
        if (head == null) return null; 
        if (head.next == null) return head; 
         
        // Find the end node and the size of the LinkedList 
        int size = 1; 
        ListNode end = head; 
        while (end.next != null) 
        { 
            end = end.next; 
            size++; 
        } 
        end.next = head; 
 
        // Move size - n % size nodes from the head to find the break Point 
        ListNode breakpoint = head; 
        for (int i = 1; i < size - n % size; i++) breakpoint = breakpoint.next; 
         
        // Break the loop by set the breakpoint's next to null 
        ListNode newHead;  
        newHead = breakpoint.next; 
        breakpoint.next = null; 
         
        return newHead; 
    } 
}