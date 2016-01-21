// #86 Partition List 
// Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
//
//You should preserve the original relative order of the nodes in each of the two partitions.
//
//For example,
//Given 1->4->3->2->5->2 and x = 3,
//return 1->2->2->4->3->5.
// Tags:  Linked List, Two Pointers

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
    public ListNode partition(ListNode head, int x) { 
        if (head == null || head.next == null) return head; 
         
        ListNode lt = new ListNode (0); 
        ListNode gt = new ListNode (0); 
        ListNode ltHead = lt; 
        ListNode gtHead = gt; 
        ListNode cur = head; 
         
        while (cur != null) 
        { 
            head = cur.next; 
            cur.next = null; 
            int cmp = cur.val - x; 
             
            if (cmp < 0)  
            { 
                lt.next = cur; 
                lt = lt.next; 
            } 
            else 
            { 
                gt.next = cur; 
                gt = gt.next; 
            } 
            cur = head; 
        } 
        ListNode newHead; 
        if (ltHead.next != null) 
        { 
            newHead = ltHead.next; 
            lt.next = gtHead.next; 
        } 
        else newHead = gtHead.next; 
        return newHead; 
    } 
}