 // # 203 Remove Linked List Elements 
//Remove all elements from a linked list of integers that have value val.
//
//Example
//Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
//Return: 1 --> 2 --> 3 --> 4 --> 5
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
    public ListNode removeElements(ListNode head, int val) { 
        if (head == null) return null; 
        ListNode newhead = new ListNode(0); 
        newhead.next = head; 
        
        ListNode cur = newhead; 
        ListNode pre = cur.next; 
        
        while (pre != null) 
        { 
            while (pre != null && pre.val == val) 
                pre = pre.next; 
            cur.next = pre; 
            if (pre == null) break; 
            cur = cur.next; 
            pre = pre.next; 
        } 
        return newhead.next; 
    } 
}