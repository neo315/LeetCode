//// #82 Remove Duplicates from Sorted List II 
////Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
//
//For example,
//Given 1->2->3->3->4->4->5, return 1->2->5.
//Given 1->1->1->2->3, return 2->3.
// Tags: Linked List
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
    public ListNode deleteDuplicates(ListNode head) { 
       if (head == null || head.next == null) return head; 
        ListNode helper = new ListNode(0); 
        helper.next = head; 
        ListNode p1 = helper; 
        ListNode p2 = p1.next.next; 
         
        while (p2 != null) 
        { 
            if (p2.val != p1.next.val) 
            { 
                p1 = p1.next; 
                p2 = p2.next; 
            } 
            else  
            { 
                while (p2.val == p1.next.val) 
                {  
                    if (p2.next == null || p2.next.val != p1.next.val) break; 
                    p2 = p2.next; 
                } 
                p1.next = p2.next; 
                if (p2.next == null) break; 
                p2.next = null; 
                p2 = p1.next.next; 
            } 
        } 
        return helper.next; 
    } 
}
