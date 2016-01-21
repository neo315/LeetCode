// #148 Sort List
// Sort a linked list in O(n log n) time using constant space complexity.
// Tags: Linked List, Sort
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
    public ListNode sortList(ListNode head) { 
        if (head == null || head.next == null) return head; 
 
        ListNode lt = new ListNode(0); 
        ListNode gt = new ListNode(0); 
        ListNode et = new ListNode(0); 
        ListNode ltHead = lt; 
        ListNode etHead = et; 
        ListNode gtHead = gt; 
        ListNode cur = head.next; 
 
        while (cur != null) 
        { 
            cur = head.next; 
            head.next = cur.next; 
            cur.next = null; 
            int cmp = cur.val - head.val; 
            if (cmp < 0)  
            { 
                lt.next = cur; 
                lt = lt.next; 
            } 
            else if (cmp > 0) 
            { 
                gt.next = cur; 
                gt = gt.next; 
            } 
            else 
            { 
                et.next = cur; 
                et = et.next; 
            } 
            cur = head.next;          
        } 
            et.next = head; 
 
        ltHead.next = sortList(ltHead.next); 
        gtHead.next = sortList(gtHead.next); 
         
        ListNode newHead = merge(ltHead.next, etHead.next, gtHead.next); 
        return newHead; 
    } 
     
    private ListNode merge(ListNode front, ListNode mid, ListNode back) 
    { 
        ListNode head = front; 
        if (head == null) head = mid; 
        ListNode frontEnd = findEnd(head); 
        ListNode midEnd = findEnd(mid); 
        frontEnd.next = mid; 
        midEnd.next = back; 
        return head; 
    } 
     
    private ListNode findEnd(ListNode head) 
    { 
        if (head == null || head.next == null) return head; 
        ListNode cur = head; 
        while (cur.next != null) cur = cur.next; 
        return cur; 
    } 
}