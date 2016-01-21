// # 206 Reverse Linked List 
//Reverse a singly linked list.
//
//click to show more hints.
//
//Hint:
//A linked list can be reversed either iteratively or recursively. Could you implement both?
//
//Tags: Linked List

/** 
 * Definition for singly-linked list. 
 * public class ListNode { 
 *     int val; 
 *     ListNode next; 
 *     ListNode(int x) { val = x; } 
 * } 
 */ 

public class Solution { 
    public ListNode reverseList(ListNode head) { 
        if (head == null || head.next == null) return head; 
         
        ListNode newhead = new ListNode(0); 
        newhead.next = head; 
         
        ListNode cur = head; 
        ListNode pre = cur.next; 
        while (pre != null) 
        { 
            ListNode temp = pre.next; 
            pre.next = cur; 
            cur = pre; 
            pre = temp; 
        } 
        newhead.next.next = null; 
        newhead.next = cur; 
        return newhead.next; 
    } 
}