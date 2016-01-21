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
public class Solution2 { 
    public ListNode deleteDuplicates(ListNode head) { 
       if (head == null || head.next == null) return head; 
        ListNode helper = new ListNode(0); 
        helper.next = head; 
        ListNode p1 = helper; 
        ListNode p2 = p1; 
         
        while (p2 != null) 
        { 
            while (p2.next != null && p1.next.val == p2.next.val) 
                p2 = p2.next; 
            if (p1.next == p2) p1 = p1.next; 
            else p1.next = p2.next; 
            p2 = p2.next; 
        } 
        return helper.next; 
 
    } 
}