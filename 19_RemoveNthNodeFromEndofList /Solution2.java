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
    public ListNode removeNthFromEnd(ListNode head, int n) { 
        if (head == null || head.next == null) return null; 
        ListNode helper = new ListNode(0); 
        helper.next = head; 
        ListNode fast = helper; 
        ListNode slow = helper; 
 
        for (int i = 0; i < n + 1; i++) 
            fast = fast.next; 
         
        while (fast != null) 
        { 
            fast =fast.next; 
            slow = slow.next; 
        } 
 
        slow.next = slow.next.next; 
        return helper.next; 
    } 
}