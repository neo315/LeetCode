// #147 Insertion Sort List 
// Sort a linked list using insertion sort.

// Tags: Linked List, Sort

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
   public ListNode insertionSortList(ListNode head) {   
     
    if (head == null) return head; 
    ListNode helper = new ListNode(0); 
    ListNode cur = head; 
     
    while (cur != null) 
    { 
        ListNode next = cur.next; 
        ListNode pre = helper; 
        while (pre.next != null && pre.next.val <= cur.val) 
            pre = pre.next; 
         
        cur.next = pre.next; 
        pre.next = cur; 
        cur = next; 
   } 
 return helper.next; 
 }   
}
