// # 23 Merge k Sorted Lists 
//Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
//
//Tags: Divide and Conquer, Linked List, Heap

/** 
 * Definition for singly-linked list. 
 * public class ListNode { 
 *     int val; 
 *     ListNode next; 
 *     ListNode(int x) { val = x; } 
 * } 
 */ 
public class Solution { 
    public ListNode mergeKLists(ListNode[] lists) { 
        if (lists == null || lists.length == 0) return null; 
         
        return helper(lists, 0, lists.length-1); 
    } 
     
    private ListNode helper(ListNode[] lists, int left, int right) 
    { 
        if (left < right) 
        { 
            int mid = (left + right) / 2; 
            return merge(helper(lists, left, mid), helper(lists, mid+1, right)); 
        } 
        else return lists[left]; 
    } 
     
    private ListNode merge(ListNode l1, ListNode l2) 
    { 
        ListNode head = new ListNode(0); 
        if (l1 != null) head.next = l1; 
        else head.next = l2; 
        ListNode cur = head; 
        while (l1 != null && l2 != null) 
        { 
            if (l1.val < l2.val) l1 = l1.next; 
             
            else 
            { 
                ListNode next = l2.next; 
                cur.next = l2; 
                l2.next = l1; 
                l2 = next; 
            } 
            cur = cur.next; 
        } 
        if (l2 != null) 
            cur.next = l2; 
        return head.next; 
    } 
}