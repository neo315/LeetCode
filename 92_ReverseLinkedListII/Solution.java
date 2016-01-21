// # 92 Reverse Linked List II 
//Reverse a linked list from position m to n. Do it in-place and in one-pass.
//
//For example:
//Given 1->2->3->4->5->NULL, m = 2 and n = 4,
//
//return 1->4->3->2->5->NULL.
//
//Note:
//Given m, n satisfy the following condition:
//1 ² m ² n ² length of list.
//
// Tags: Linked List

/** 
 * Definition for singly-linked list. 
 * public class ListNode { 
 *     int val; 
 *     ListNode next; 
 *     ListNode(int x) { val = x; } 
 * } 
 */ 
public class Solution { 
    public ListNode reverseBetween(ListNode head, int m, int n) { 
        if (head == null) return null; 
 
        ListNode newHead = new ListNode(0); 
        newHead.next = head; 
        ListNode start = newHead; 
 
        for (int i = 0; i < m - 1; i++) 
            start = start.next; 
        ListNode cur = start.next; 
        ListNode pre = cur.next; 
         
        for (int i = 0; i < n - m; i++) 
        { 
            ListNode temp = pre.next; 
            pre.next = cur; 
            cur = pre; 
            pre = temp; 
        } 
        start.next.next = pre; 
        start.next = cur; 
        return newHead.next; 
    } 
}